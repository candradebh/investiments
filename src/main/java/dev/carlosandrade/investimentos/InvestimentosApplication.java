package dev.carlosandrade.investimentos;

import dev.carlosandrade.investimentos.entity.Ativo;
import dev.carlosandrade.investimentos.repository.AtivoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvestimentosApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(InvestimentosApplication.class);

	public static void main(String[] args) {

		logger.info("BEFORE START APP");
		SpringApplication.run(InvestimentosApplication.class, args);
		logger.info("AFTER START APP");

		System.out.println("No AR");
	}


	@Override
	public void run(String... args) throws Exception {


		/*
		Ativo ativo1 = Ativo.builder().ticker("VALE3").nome("VALE ON").tipoAtivo("Ações").build();
		Ativo ativo2 = Ativo.builder().ticker("PETR3").nome("PETROBRAS ON").tipoAtivo("Ações").build();
		Ativo ativo3 = Ativo.builder().ticker("PETR4").nome("PETROBRAS PN").tipoAtivo("Ações").build();

		ativoRepository.save(ativo1);
		ativoRepository.save(ativo2);
		ativoRepository.save(ativo3);
		*/
	}
}
