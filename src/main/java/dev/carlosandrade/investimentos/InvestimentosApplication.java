package dev.carlosandrade.investimentos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvestimentosApplication {

	private static Logger logger = LoggerFactory.getLogger(InvestimentosApplication.class);

	public static void main(String[] args) {
		logger.info("START APP");
		SpringApplication.run(InvestimentosApplication.class, args);
		logger.info("No ar ... ");
	}

}
