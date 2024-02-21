package io.gitub.mscartoes.mscartoes.application;


import com.netflix.discovery.converters.Auto;
import io.gitub.mscartoes.mscartoes.application.domain.Cartao;
import io.gitub.mscartoes.mscartoes.infra.repository.CartaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {
    @Autowired
    CartaoRepository repository;

    @Transactional
    public Cartao save(Cartao cartao) {
        return repository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
        BigDecimal valor = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(valor);
    }

}
