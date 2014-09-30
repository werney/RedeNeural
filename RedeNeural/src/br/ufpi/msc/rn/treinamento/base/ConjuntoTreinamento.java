package br.ufpi.msc.rn.treinamento.base;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoTreinamento {
	
	private List<Amostra> dadosTreinamento;
	
	public ConjuntoTreinamento(){
		dadosTreinamento = new ArrayList<>();
	}

	/**
	 * @return the dadosTreinamento
	 */
	public List<Amostra> getDadosTreinamento() {
		return dadosTreinamento;
	}

	/**
	 * @param dadosTreinamento the dadosTreinamento to set
	 */
	public void setDadosTreinamento(List<Amostra> dadosTreinamento) {
		this.dadosTreinamento = dadosTreinamento;
	}
	
	
}
