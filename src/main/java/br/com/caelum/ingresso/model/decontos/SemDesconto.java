package br.com.caelum.ingresso.model.decontos;

import java.math.BigDecimal;

public class SemDesconto implements Desconto {
	
	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}
	
	@Override
	public String getDescricao() {
		return "Normal";
	}

}
