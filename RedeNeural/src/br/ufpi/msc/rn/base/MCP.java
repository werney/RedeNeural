package br.ufpi.msc.rn.base;


public class MCP {
	
	private double[] entradas;
	private double[] pesos;
	private double limiarAtivacao;
	private double b;
	private FuncaoAtivacao funcaoAtivacao;
	private double saida;
	
	/**
	 * @param pesos
	 * @param limiarAtivacao
	 */
	public MCP(double[] pesos, double limiarAtivacao, FuncaoAtivacao funcaoAtivacao, double b) {
		super();
		this.pesos = pesos;
		this.limiarAtivacao = limiarAtivacao;
		this.funcaoAtivacao = funcaoAtivacao;
		this.b = b;
	}
	
	public double calcular(double[] entradas){
		double sum = 0.0;
		for(int i = 0; i < entradas.length; i++)
			sum += entradas[i] * pesos[i];
		
		double u = sum - limiarAtivacao;
		if(funcaoAtivacao == FuncaoAtivacao.DEGRAU){
			return funcaoDegrau(u);
		}else if(funcaoAtivacao == FuncaoAtivacao.TANGENTE_HIPERBOLICA){
			return funcaoTangenteHiperbolica(b, u);
		}else if(funcaoAtivacao == FuncaoAtivacao.DEGRAU_BIPOLAR){
			return funcaoDegrauBipolar(u);
		}
		
		return 123.0;
	}
	
	public double funcaoDegrau(double u){
		if(u >= 0)
			return 1;
		return 0;
	}
	
	public double funcaoTangenteHiperbolica(double b, double u){
		return ((1 - (Math.exp((-1 * b) * u)))/ (1 + (Math.exp((-1 * b) * u)))); 
	}
	
	public double funcaoDegrauBipolar(double u){
		if(u > 0)
			return 1;
		else if(u < 0)
			return -1;
		return 0;
	}

	/**
	 * @return the limiarAtivacao
	 */
	public double getLimiarAtivacao() {
		return limiarAtivacao;
	}

	/**
	 * @param limiarAtivacao the limiarAtivacao to set
	 */
	public void setLimiarAtivacao(double limiarAtivacao) {
		this.limiarAtivacao = limiarAtivacao;
	}

	/**
	 * @return the saida
	 */
	public double getSaida() {
		return saida;
	}

	/**
	 * @param saida the saida to set
	 */
	public void setSaida(double saida) {
		this.saida = saida;
	}

	/**
	 * @return the funcaoAtivacao
	 */
	public FuncaoAtivacao getFuncaoAtivacao() {
		return funcaoAtivacao;
	}

	/**
	 * @param funcaoAtivacao the funcaoAtivacao to set
	 */
	public void setFuncaoAtivacao(FuncaoAtivacao funcaoAtivacao) {
		this.funcaoAtivacao = funcaoAtivacao;
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
	 * @return the pesos
	 */
	public double[] getPesos() {
		return pesos;
	}

	/**
	 * @param pesos the pesos to set
	 */
	public void setPesos(double[] pesos) {
		this.pesos = pesos;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}
	
}
