package it.atvinformatica.springboot.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Entity
@Table(name = "pagamentiDigitali")
public class PagamentoDigitale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private float importo;
    @Column(nullable = false)
    private String valuta;
    @Column(nullable = false)
    private String causale;

    @Column(nullable = false)
    private Instant dataOra;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getImporto() {
		return importo;
	}
	public void setImporto(float importo) {
		this.importo = importo;
	}
	public String getValuta() {
		return valuta;
	}
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
    
	public Instant getDataOra() {
		return dataOra;
	}
	public void setDataOra(Instant dataOra) {
		this.dataOra = dataOra;
	}
}


