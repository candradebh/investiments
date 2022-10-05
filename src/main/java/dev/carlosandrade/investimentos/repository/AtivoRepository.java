package dev.carlosandrade.investimentos.repository;

import dev.carlosandrade.investimentos.models.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {


    Optional<Ativo> findByTicker(String ticker);


}