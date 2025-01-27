package it.atvinformatica.springboot.service;
import lombok.AllArgsConstructor;
import it.atvinformatica.springboot.entity.PagamentoDigitale;
import it.atvinformatica.springboot.repository.PagamentoDigitaleRepository;
import it.atvinformatica.springboot.service.PagamentoDigitaleService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PagamentoDigitaleServiceImpl implements PagamentoDigitaleService {
	@Autowired
    private PagamentoDigitaleRepository pagamentoDigitaleRepository;
	
    @Override
    public PagamentoDigitale createPagamentoDigitale(PagamentoDigitale pagamentoDigitale) {
    	Instant instant = Instant.now().with( ChronoField.NANO_OF_SECOND , 123_456_789L ) ;  //Set the fractional second to a spefic number of nanoseconds.
    	pagamentoDigitale.setDataOra(instant);
        return pagamentoDigitaleRepository.save(pagamentoDigitale);
    }

    @Override
    public PagamentoDigitale getPagamentoDigitaleById(Long pagamentoDigitaleId) {
        Optional<PagamentoDigitale> optionalUser = pagamentoDigitaleRepository.findById(pagamentoDigitaleId);
        return optionalUser.get();
    }

    @Override
    public List<PagamentoDigitale> getAllPagamentiDigitali() {
        return pagamentoDigitaleRepository.findAll();
    }

    @Override
    public PagamentoDigitale updatePagamentoDigitale(PagamentoDigitale pagamentoDigitale) {
    	PagamentoDigitale existingPagamentoDigitale = pagamentoDigitaleRepository.findById(pagamentoDigitale.getId()).get();
    	existingPagamentoDigitale.setImporto(pagamentoDigitale.getImporto());
    	existingPagamentoDigitale.setValuta(pagamentoDigitale.getValuta());
    	existingPagamentoDigitale.setCausale(pagamentoDigitale.getCausale());
    	Instant instant = Instant.now().with( ChronoField.NANO_OF_SECOND , 123_456_789L ) ;  //Set the fractional second to a spefic number of nanoseconds.
    	existingPagamentoDigitale.setDataOra(instant);
        PagamentoDigitale updatedPagamentoDigitale = pagamentoDigitaleRepository.save(existingPagamentoDigitale);
        return updatedPagamentoDigitale; 
    }

    @Override
    public void deletePagamentoDigitale(Long pagamentoDigitaleId) {
    	pagamentoDigitaleRepository.deleteById(pagamentoDigitaleId);
    }
}
