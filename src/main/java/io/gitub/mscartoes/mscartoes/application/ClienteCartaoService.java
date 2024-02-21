package io.gitub.mscartoes.mscartoes.application;

import io.gitub.mscartoes.mscartoes.infra.repository.CartaoRepository;
import io.gitub.mscartoes.mscartoes.infra.repository.ClienteCartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {

    @Autowired
    ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
