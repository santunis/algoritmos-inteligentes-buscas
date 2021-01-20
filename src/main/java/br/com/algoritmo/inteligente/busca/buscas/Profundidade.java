package br.com.algoritmo.inteligente.busca.buscas;

import br.com.algoritmo.inteligente.busca.estruturas.Pilha;
import br.com.algoritmo.inteligente.busca.grafocidades.Adjacente;
import br.com.algoritmo.inteligente.busca.grafocidades.Cidade;
import br.com.algoritmo.inteligente.busca.grafocidades.Mapa;

public class Profundidade {
	
	private Pilha fronteira;
	private Cidade inicio;
	private Cidade objetivo;
	private boolean achou;
	
	public Profundidade(Cidade inicio, Cidade objetivo) {
		this.inicio = inicio;
		this.inicio.setVisitado(true);
		this.objetivo = objetivo;
		
		fronteira  = new Pilha(20);
		fronteira.empilhar(inicio);
		achou = false;
	}
	
	public void buscar() {
		Cidade topo = fronteira.getTopo();
		System.out.println("Topo: " + topo.getNome());
		
		if (topo == objetivo) {
			achou = true;
		} else {
			for (Adjacente a : topo.getAdjacentes()) {
				if (!achou) {
					System.out.println("Verificando se j� visitado: " + a.getCidade().getNome());
					if (!a.getCidade().isVisitado()) {
						a.getCidade().setVisitado(true);
						fronteira.empilhar(a.getCidade());
						buscar();
					}
				}
			}
		}
		System.out.println("Desempilhou: " + fronteira.desempilhar().getNome());
		
	}
	
	public static void main(String args[]) {
		Mapa mapa = new Mapa();
		Profundidade p = new Profundidade(mapa.getPortoUniao(), mapa.getCuritiba());
		p.buscar();
	}

}
