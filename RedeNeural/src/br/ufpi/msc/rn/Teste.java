package br.ufpi.msc.rn;

public class Teste {
	public static void main(String[] args) {
		double[][] entradas = {{0,0},{0,0.25},{0.25,0.40},{0.9,0.3},{0.55,0.3},{1,1},{0.14,0.29},{0.92,0.19},{0.26,0.39},{0.19,0.78}};
		double[] pesos1 = {0.6,0.7};
		double[] pesos2 = {0.4,0.2};
		double[] pesos3 = {0.1,0.3};
		double[] pesos4 = {0.6,0.5,0.4};
		
		for(int i = 0; i< entradas.length; i++){
			double ya = pesos1[0] * entradas[i][0] + pesos1[1] * entradas[i][1] - 0.1;
			double yb = pesos2[0] * entradas[i][0] + pesos2[1] * entradas[i][1] - 0.8;
			double yc = pesos3[0] * entradas[i][0] + pesos3[1] * entradas[i][1] - 0.5;
			double y1 = pesos4[0] * ya + pesos4[1] * yb + pesos4[2] * yc - 0.2;
			System.out.println(ya + " " + yb + " " + yc + " " + y1);
		}
	}
	
}
