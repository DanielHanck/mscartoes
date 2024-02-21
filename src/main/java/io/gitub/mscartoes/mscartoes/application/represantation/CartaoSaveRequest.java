package io.gitub.mscartoes.mscartoes.application.represantation;

import io.gitub.mscartoes.mscartoes.application.domain.BandeiraCartao;
import io.gitub.mscartoes.mscartoes.application.domain.Cartao;
import lombok.Data;


import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }
}
