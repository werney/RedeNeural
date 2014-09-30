package br.ufpi.msc.rn.arquitetura.camada;

import java.util.HashMap;

import br.ufpi.msc.rn.base.MCP;

public class CamadaNeural {
	
	private HashMap<Integer, MCP> neuronios;
	
	/**
	 * @param neuronios
	 */
	public CamadaNeural(HashMap<Integer, MCP> neuronios) {
		super();
		this.neuronios = neuronios;
	}
	
	public double[] calculate(double[] entradas){
		double[] saidas = new double[neuronios.size()];
		int i = 0;
		for(MCP neuronio : neuronios.values()){
			saidas[i] = neuronio.calcular(entradas);
			i++;
		}
		return saidas;
	}

	public void addNeuronio(int indice, MCP neuronio){
		neuronios.put(indice, neuronio);
	}
	
	public void removeNeuronio(int indice){
		neuronios.remove(indice);
	}

	/**
	 * @return the neuronios
	 */
	public HashMap<Integer, MCP> getNeuronios() {
		return neuronios;
	}

	/**
	 * @param neuronios the neuronios to set
	 */
	public void setNeuronios(HashMap<Integer, MCP> neuronios) {
		this.neuronios = neuronios;
	}
	
	
}
