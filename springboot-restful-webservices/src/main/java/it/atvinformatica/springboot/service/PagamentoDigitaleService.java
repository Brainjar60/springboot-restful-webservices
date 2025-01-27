package it.atvinformatica.springboot.service;

import it.atvinformatica.springboot.entity.PagamentoDigitale;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PagamentoDigitaleService {
	
	PagamentoDigitale createPagamentoDigitale(PagamentoDigitale pagamentoDigitale);

	PagamentoDigitale getPagamentoDigitaleById(Long pagamentoDigitaleId);

    List<PagamentoDigitale> getAllPagamentiDigitali();

    PagamentoDigitale updatePagamentoDigitale(PagamentoDigitale pagamentoDigitale);

    void deletePagamentoDigitale(Long pagamentoDigitaleId);
}