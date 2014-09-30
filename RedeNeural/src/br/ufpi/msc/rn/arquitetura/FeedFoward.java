package br.ufpi.msc.rn.arquitetura;

import java.util.List;

import br.ufpi.msc.rn.arquitetura.camada.CamadaNeural;
import br.ufpi.msc.rn.base.MCP;
import br.ufpi.msc.rn.treinamento.base.Amostra;
import br.ufpi.msc.rn.treinamento.base.ConjuntoTreinamento;

public class FeedFoward {
	
	private int numEntradas;
	private int numSaidas;
	private List<CamadaNeural> camadasNeurais;
	
	/**
	 * @param numEntradas
	 * @param numSaidas
	 * @param camadaNaoNeural
	 * @param camadasNeurais
	 */
	public FeedFoward(int numEntradas, int numSaidas, List<CamadaNeural> camadasNeurais) {
		super();
		this.numEntradas = numEntradas;
		this.numSaidas = numSaidas;
		this.camadasNeurais = camadasNeurais;
	}

	public double[] calculate(double[] entradas){
		double[] saidas = entradas;
		for(CamadaNeural camadaNeural : camadasNeurais){
			saidas = camadaNeural.calculate(saidas);
		}
		return saidas;
	}
	
	public void treinamentoAleatorio(ConjuntoTreinamento conjuntoTreinamento, int maxEpocas){
		boolean erro = true;
		int j = 0;
		while(erro && (j < maxEpocas)){
			erro = false;
			for(Amostra amostra : conjuntoTreinamento.getDadosTreinamento()){
				double[] result = calculate(amostra.getEntradas());
				for(int i = 0; i < result.length; i++){
					if(result[i] != amostra.getSaidas()[i]){
						pesosAleatorios();
						erro = true;
					}
				}
			}
			j++;
		}
	}
	
	public void pesosAleatorios(){
		for(CamadaNeural camadaNeural : camadasNeurais){
			for(MCP neuronio : camadaNeural.getNeuronios().values()){
				neuronio.setLimiarAtivacao(Math.random());
				for(int i = 0; i < neuronio.getPesos().length; i++){
					neuronio.getPesos()[i] = Math.random();
				}
			}
		}
	}
	
	/**
	 * @return the camadasNeurais
	 */
	public List<CamadaNeural> getCamadasNeurais() {
		return camadasNeurais;
	}
	
	/**
	 * @param camadasNeurais the camadasNeurais to set
	 */
	public void setCamadasNeurais(List<CamadaNeural> camadasNeurais) {
		this.camadasNeurais = camadasNeurais;
	}

	/**
	 * @return the numEntradas
	 */
	public int getNumEntradas() {
		return numEntradas;
	}

	/**
	 * @param numEntradas the numEntradas to set
	 */
	public void setNumEntradas(int numEntradas) {
		this.numEntradas = numEntradas;
	}

	/**
	 * @return the numSaidas
	 */
	public int getNumSaidas() {
		return numSaidas;
	}

	/**
	 * @param numSaidas the numSaidas to set
	 */
	public void setNumSaidas(int numSaidas) {
		this.numSaidas = numSaidas;
	}
	
}
