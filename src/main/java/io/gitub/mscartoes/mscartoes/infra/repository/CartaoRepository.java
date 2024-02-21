package io.gitub.mscartoes.mscartoes.infra.repository;

import io.gitub.mscartoes.mscartoes.application.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long>  {
    List<Cartao> findByRendaLessThanEqual(BigDecimal valor);
}
