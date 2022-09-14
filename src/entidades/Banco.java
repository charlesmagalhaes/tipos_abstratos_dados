package entidades;

public class Banco {
	
	private int qtdItens = 0;
	private int capacidade = 3;

	TContaBancaria[] listaContas = new TContaBancaria[capacidade];
	
	
	public boolean criarConta(TContaBancaria conta){
		if(qtdItens+1 <= capacidade) {
			listaContas[qtdItens] = new TContaBancaria(conta);
		qtdItens += 1;
		} 
		
		aumentarCapacidadeArray();
		
		listaContas[qtdItens] = new TContaBancaria(conta);
		qtdItens += 1;
		
		return true;
	}

	private void aumentarCapacidadeArray() {
		capacidade +=1;
		
		TContaBancaria[] listaTemporaria = listaContas;
		listaContas = new TContaBancaria[capacidade];
		
		for (int i=0; i< listaTemporaria.length;i++) {
			listaContas[i] = listaTemporaria[i];
		}
	}
	
	public void imprimirListaContas() {
		for(int i=0; i < qtdItens ;i++) {
			System.out.println(listaContas[i].toString());
			
		}
	}
	
	public TContaBancaria procurarConta(int numConta) {		
		for (int i=0; i < qtdItens ;i++) {
			if (listaContas[i].getNumeroConta() == numConta) {
				return listaContas[i];
				
			}
		}
		
		return null;
	}

}
