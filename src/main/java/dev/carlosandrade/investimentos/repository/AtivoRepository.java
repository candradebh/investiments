package dev.carlosandrade.investimentos.repository;

import dev.carlosandrade.investimentos.entity.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface AtivoRepository extends JpaRepository<Ativo, Long> {


    Optional<Ativo> findByTicker(String ticker);


}