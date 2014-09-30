package br.ufpi.msc.rn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufpi.msc.rn.arquitetura.FeedFoward;
import br.ufpi.msc.rn.arquitetura.camada.CamadaNeural;
import br.ufpi.msc.rn.base.FuncaoAtivacao;
import br.ufpi.msc.rn.base.MCP;
import br.ufpi.msc.rn.treinamento.base.Amostra;
import br.ufpi.msc.rn.treinamento.base.ConjuntoTreinamento;

public class Main {
	public static void main(String[] args) {
		
//		List<List<Double>> entradas = new ArrayList<>();
//		for(int i = 0; i < 20; i++){
//			List<Double> temp = new ArrayList<>();
//			temp.add(i/20.0);
//			temp.add(i/20.0);
//			entradas.add(temp);
//		}
//
//		HashMap<Integer, MCP> neuronios = new HashMap<>();
//		
//		double[] pesos = {0.9, 0.5};
//		MCP mcp = new MCP(pesos, 0.5, FuncaoAtivacao.TANGENTE_HIPERBOLICA, 1.0);
//		neuronios.put(0, mcp);
//		
//		CamadaNeural camadaNeural = new CamadaNeural(neuronios);
//		List<CamadaNeural> camadasNeurais = new ArrayList<>();
//		camadasNeurais.add(camadaNeural);
//		FeedFoward redeneural = new FeedFoward(2, 1, camadasNeurais);
//		for(int i = 0; i < 20; i++)
//			System.out.println(redeneural.calculate(entradas.get(i)));
		
		ConjuntoTreinamento conjuntoTreinamento = new ConjuntoTreinamento();
		double[] entradas = {0.9,0.1};
		double[] saidas = {1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas, saidas));
		double[] entradas2 = {0.6,0.5};
		double[] saidas2 = {1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas2, saidas2));
		double[] entradas3 = {0.2,0.8};
		double[] saidas3 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas3, saidas3));
		double[] entradas4 = {0.7,0.2};
		double[] saidas4 = {1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas4, saidas4));
		double[] entradas5 = {0.5,0.4};
		double[] saidas5 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas5, saidas5));
		double[] entradas6 = {0.4,0.6};
		double[] saidas6 = {1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas6, saidas6));
		double[] entradas7 = {0.25,0.8};
		double[] saidas7 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas7, saidas7));
		double[] entradas8 = {0.1,0.9};
		double[] saidas8 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas8, saidas8));
		double[] entradas9 = {0.3,0.7};
		double[] saidas9 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas9, saidas9));
		double[] entradas10 = {0.0,1.0};
		double[] saidas10 = {-1};
		conjuntoTreinamento.getDadosTreinamento().add(new Amostra(entradas10, saidas10));
		
		
		HashMap<Integer, MCP> neuronios = new HashMap<>();
		
		double[] pesos = {0.5, 0.5};
		MCP mcp = new MCP(pesos, 0.5, FuncaoAtivacao.DEGRAU_BIPOLAR, 0.0);
		neuronios.put(0, mcp);
		
		CamadaNeural camadaNeural = new CamadaNeural(neuronios);
		List<CamadaNeural> camadasNeurais = new ArrayList<>();
		camadasNeurais.add(camadaNeural);
		FeedFoward redeneural = new FeedFoward(2, 1, camadasNeurais);
		redeneural.treinamentoAleatorio(conjuntoTreinamento, 100);
		for(int i = 0; i < conjuntoTreinamento.getDadosTreinamento().size(); i++)
			System.out.println(redeneural.calculate(conjuntoTreinamento.getDadosTreinamento().get(i).getEntradas())[0] 
					+ " " + conjuntoTreinamento.getDadosTreinamento().get(i).getSaidas()[0]);
		
		
//		List<Double> entradas = new ArrayList<>();
//		List<Double> pesos = new ArrayList<>();
//		
//		/* Questao 4*/
//		System.out.println("Questao 4");
//		
//		entradas.add(0.0);
//		entradas.add(0.0);
//		pesos.add(1.0);
//		pesos.add(1.0);
//		MCP mcp = new MCP(pesos, 1.1);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(0.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(0.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 5 */
//		System.out.println("Questao 5");
//		
//		entradas.add(0.0);
//		entradas.add(0.0);
//		pesos.add(0.2);
//		pesos.add(0.8);
//		mcp = new MCP(pesos, 0.1);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(0.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(0.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 6 */
//		System.out.println("Questao 6");
//		
//		entradas.add(0.0);
//		entradas.add(0.0);
//		pesos.add(0.8);
//		pesos.add(-0.2);
//		mcp = new MCP(pesos, 0.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(0.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(0.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		entradas.clear();
//		
//		entradas.add(1.0);
//		entradas.add(1.0);
//		System.out.println(mcp.calcular(entradas, 0.0, FuncaoAtivacao.DEGRAU));
//		
//		/* Questao 7 */
//		System.out.println("Questao 7");
//		
//		entradas.add(0.3);
//		entradas.add(0.7);
//		pesos.add(0.4);
//		pesos.add(0.5);
//		mcp = new MCP(pesos, 0.2);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 8 */
//		System.out.println("Questao 8");
//		
//		entradas.add(0.3);
//		entradas.add(0.7);
//		pesos.add(0.6);
//		pesos.add(0.7);
//		mcp = new MCP(pesos, 0.3);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 9 */
//		System.out.println("Questao 9");
//		
//		entradas.add(0.3);
//		entradas.add(0.7);
//		pesos.add(0.8);
//		pesos.add(0.3);
//		mcp = new MCP(pesos, 0.4);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 10 */
//		System.out.println("Questao 10");
//		
//		entradas.add(0.26);
//		entradas.add(0.35);
//		entradas.add(0.05);
//		pesos.add(0.6);
//		pesos.add(0.2);
//		pesos.add(0.7);
//		mcp = new MCP(pesos, -0.7);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 11 */
//		System.out.println("Questao 11");
//		
//		entradas.add(0.26);
//		entradas.add(0.35);
//		entradas.add(0.05);
//		pesos.add(0.7);
//		pesos.add(0.2);
//		pesos.add(0.8);
//		mcp = new MCP(pesos, -0.3);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
//		
//		entradas.clear();
//		pesos.clear();
//		
//		/* Questao 12 */
//		System.out.println("Questao 12");
//		
//		entradas.add(0.74);
//		entradas.add(0.53);
//		pesos.add(0.8);
//		pesos.add(0.5);
//		mcp = new MCP(pesos, 0.1);
//		System.out.println(mcp.calcular(entradas, 1.0, FuncaoAtivacao.TANGENTE_HIPERBOLICA));
		
	}
}
