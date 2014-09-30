package br.ufpi.msc.rn.treinamento.base;

public class Amostra {
	
	double[] entradas;
	double[] saidas;
	
	/**
	 * @param entradas
	 * @param saidas
	 */
	public Amostra(double[] entradas, double[] saidas) {
		super();
		this.entradas = entradas;
		this.saidas = saidas;
	}

	/**
	 * @return the entradas
	 */
	public double[] getEntradas() {
		return entradas;
	}

	/**
	 * @param entradas the entradas to set
	 */
	public void setEntradas(double[] entradas) {
		this.entradas = entradas;
	}

	/**
	 * @return the saidas
	 */
	public double[] getSaidas() {
		return saidas;
	}

	/**
	 * @param saidas the saidas to set
	 */
	public void setSaidas(double[] saidas) {
		this.saidas = saidas;
	}
	
	
	
}
