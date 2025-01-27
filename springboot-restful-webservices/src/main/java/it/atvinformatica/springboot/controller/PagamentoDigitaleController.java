package it.atvinformatica.springboot.controller;


import lombok.AllArgsConstructor;
import it.atvinformatica.springboot.entity.PagamentoDigitale;
import it.atvinformatica.springboot.service.PagamentoDigitaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/pagamentiDigitali")
public class PagamentoDigitaleController {
	@Autowired
    private PagamentoDigitaleService pagamentoDigitaleService;

    // build create PagamentoDigitale REST API
    @PostMapping
    public ResponseEntity<PagamentoDigitale> createPagamentoDigitale(@RequestBody PagamentoDigitale pagamentoDigitale){
    	PagamentoDigitale savedPagamentoDigitale = pagamentoDigitaleService.createPagamentoDigitale(pagamentoDigitale);
        return new ResponseEntity<>(savedPagamentoDigitale, HttpStatus.CREATED);
    }

    // build get pagamento digitale by id REST API
    // http://localhost:8080/api/pagamentiDigitali/1
    @GetMapping("{id}")
    public ResponseEntity<PagamentoDigitale> getPagamentoDigitaleById(@PathVariable("id") Long pagamentoDigitaleId){
    	PagamentoDigitale pagamentoDigitale = pagamentoDigitaleService.getPagamentoDigitaleById(pagamentoDigitaleId);
        return new ResponseEntity<>(pagamentoDigitale, HttpStatus.OK);
    }

    // Build Get All Pagamenti Digitali REST API
    // http://localhost:8080/api/pagamentiDigitali
    @GetMapping
    public ResponseEntity<List<PagamentoDigitale>> getAllPagamentiDigitali(){
        List<PagamentoDigitale> users = pagamentoDigitaleService.getAllPagamentiDigitali();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update Pagamenti Digitali REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/pagamentiDigitali/1
    public ResponseEntity<PagamentoDigitale> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody PagamentoDigitale pagamentoDigitale){
    	pagamentoDigitale.setId(userId);
    	PagamentoDigitale updatedPagamentoDigitale = pagamentoDigitaleService.updatePagamentoDigitale(pagamentoDigitale);
        return new ResponseEntity<>(updatedPagamentoDigitale, HttpStatus.OK);
    }

    // Build Delete Pagamenti Digitali REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePagamentoDigitale(@PathVariable("id") Long pagamentoDigitaleId){
    	pagamentoDigitaleService.deletePagamentoDigitale(pagamentoDigitaleId);
        return new ResponseEntity<>("PagamentoDigitale successfully deleted!", HttpStatus.OK);
    }
}
