package dev.carlosandrade.investimentos.controllers;

import dev.carlosandrade.investimentos.entity.Ativo;
import dev.carlosandrade.investimentos.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ativos")
public class AtivosController {

    @Autowired
    AtivoRepository repository;

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody Ativo ativo) {

        //Ativo ativoBuscado = repository.findByTicker(ativo.getTicker()).stream().findFirst().orElse(null);
        Optional<Ativo> ativoBuscado = repository.findByTicker(ativo.getTicker());

        if (ativoBuscado.isPresent()) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("O  ativo " + ativo.getTicker() + " ja esta cadastrado no sistema");
        }

        return ResponseEntity.ok(repository.save(ativo));


    }

    @GetMapping("{ticker}")
    public ResponseEntity read(@PathVariable String ticker) {
        return ResponseEntity.ok(repository.findByTicker(ticker));
    }

    @PutMapping("{ticker}")
    public ResponseEntity update(@PathVariable String ticker, @Validated @RequestBody Ativo ativo) {
        return repository.findByTicker(ticker).map(existingAtivo -> {
            Ativo updatedAtivo = existingAtivo;
            updatedAtivo.setNome(ativo.getNome());
            updatedAtivo.setCnpj(ativo.getCnpj());
            return ResponseEntity.ok().body(repository.save(updatedAtivo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{ticker}")
    public ResponseEntity deletePostById(@PathVariable String ticker) {

        repository.findByTicker(ticker).map(existingAtivo -> {

            repository.delete(existingAtivo);

            return ResponseEntity.ok();

        });

        return ResponseEntity.notFound().build();

    }


}
