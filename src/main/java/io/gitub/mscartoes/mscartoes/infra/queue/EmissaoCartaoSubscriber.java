package io.gitub.mscartoes.mscartoes.infra.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.gitub.mscartoes.mscartoes.application.ClienteCartao;
import io.gitub.mscartoes.mscartoes.application.domain.Cartao;
import io.gitub.mscartoes.mscartoes.application.domain.DadosSolicitacaoEmissaocartao;
import io.gitub.mscartoes.mscartoes.infra.repository.CartaoRepository;
import io.gitub.mscartoes.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DadosSolicitacaoEmissaocartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaocartao.class);
            Cartao carto = cartaoRepository.getById(dados.getIdCartao());
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(carto);
            clienteCartao.setCpf(dados.getCpf());
            clienteCartao.setLimite(dados.getLimiteLiberado());

            clienteCartaoRepository.save(clienteCartao);


        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
