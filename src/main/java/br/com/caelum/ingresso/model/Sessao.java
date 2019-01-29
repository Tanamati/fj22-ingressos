package br.com.caelum.ingresso.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Long id;
	private LocalTime horario;
	
	@ManyToOne
	private Filme filme;
	
	@ManyToOne
	private Sala sala;
	
	private BigDecimal preco;
	
	/**
	 * @deprecated hibernate only
	 */
	public Sessao() {
		
	}
	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
		this.preco = sala.getPreco().add(filme.getPreco());
	}
	
	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public LocalTime getHorarioTermino() {
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Filme getFilme() {
		return filme;
	}

	public Sala getSala() {
		return sala;
	}


	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
}
