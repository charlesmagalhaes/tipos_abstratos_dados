package entidades;

public class Banco {
	
	private int qtdItens = 0;
	private int capacidade = 3;

	TContaBancaria[] listaContas = new TContaBancaria[capacidade];
	
	
	public boolean criarConta(TContaBancaria conta){
		if(qtdItens+1 <= capacidade) {
			listaContas[qtdItens] = new TContaBancaria(conta.getNomeCliente(), 
													conta.getCPF(), 
													conta.getNumeroConta(), 
													conta.getAgencia(),
													conta.getSaldo());
		qtdItens += 1;
		return true;
		} 
		
		return false;
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
