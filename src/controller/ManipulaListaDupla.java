package controller;
import com.deniza.utils.ListaDuplaEncadeadaInt.ListaDuplaEncadeadaInt;

public class ManipulaListaDupla {
	
	public ManipulaListaDupla() {
		super();
	}
	
	public void insere(int numero, ListaDuplaEncadeadaInt l) {
		l.insertAtBack(numero);
	}
	
	public ListaDuplaEncadeadaInt concatena(
			ListaDuplaEncadeadaInt l1, ListaDuplaEncadeadaInt l2) throws Exception {
		int tamanhoL2 = l2.size();
		int posicao = 0;
		while(posicao < tamanhoL2) {
			l1.insertAtBack(l2.getValue(posicao));
			posicao++;
		}
		return l1;
	}
	
	public ListaDuplaEncadeadaInt intercala(
			ListaDuplaEncadeadaInt l1, ListaDuplaEncadeadaInt l2) throws Exception {
		ListaDuplaEncadeadaInt listaRes = new ListaDuplaEncadeadaInt();
		
		int posicao = 0;
		int tamanho = 0;
		
		if(l1.size() >= l2.size()) {
			tamanho = l1.size();
		} else {
			tamanho = l2.size();
		}
		
		while(posicao < tamanho) {
			if(!l1.isEmpty()) {
				listaRes.insertAtBack(l1.getValue(posicao));
			}
			if(!l2.isEmpty()) {
				listaRes.insertAtBack(l2.getValue(posicao));
			}
			posicao++;
		}
		return listaRes;
	}
	
	public ListaDuplaEncadeadaInt[] divide(ListaDuplaEncadeadaInt l, int qtdListas) throws Exception {
		ListaDuplaEncadeadaInt listaRes[] = new ListaDuplaEncadeadaInt[qtdListas];
		int posicao = l.size() - 1;
		int qtdNumeros = (posicao + 1) / qtdListas;
		int resto = (posicao + 1) % qtdListas;
		
		for(int k = 0; k < qtdListas; k++) {
			listaRes[k] = new ListaDuplaEncadeadaInt();
			for(int j = 1; j <= qtdNumeros; j++) {
				if(posicao >= 0) {
					listaRes[k].insertAtFront(l.getValue(posicao));
					if(resto > 0) {
						posicao--;
						listaRes[k].insertAtFront(l.getValue(posicao));
						resto--;
					}
					posicao--;
				}
			}
		}	
		return listaRes;
	}

}
