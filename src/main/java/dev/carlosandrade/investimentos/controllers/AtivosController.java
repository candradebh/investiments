package dev.carlosandrade.investimentos.controllers;

import dev.carlosandrade.investimentos.models.Ativo;
import dev.carlosandrade.investimentos.repository.AtivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativos")
public class AtivosController {

    @Autowired
    AtivoRepository ativoRepository;

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(ativoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity create (@RequestBody Ativo ativo) {
        return ResponseEntity.ok(ativoRepository.save(ativo));
    }

    @GetMapping ("{ticker}")
    public ResponseEntity read (@PathVariable String ticker){
      return ResponseEntity.ok(ativoRepository.findByTicker(ticker));
    }

    @PutMapping("{ticker}")
    public ResponseEntity update (@PathVariable String ticker, @Validated @RequestBody  Ativo ativo)  {
        return ativoRepository.findByTicker(ticker).map(existingAtivo->{
            Ativo updatedAtivo = existingAtivo ;
            updatedAtivo.setNome(ativo.getNome());
            updatedAtivo.setCnpj(ativo.getCnpj());
            return ResponseEntity.ok().body(ativoRepository.save(updatedAtivo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{ticker}")
    public ResponseEntity deletePostById(@PathVariable String ticker) {

        ativoRepository.findByTicker(ticker).map ( existingAtivo  -> {

            ativoRepository.delete(existingAtivo);

            return ResponseEntity.ok();

        });

        return ResponseEntity.notFound().build();

    }


}
