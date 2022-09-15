package Aplicacao;

import java.util.Scanner;

import entidades.Banco;
import entidades.TContaBancaria;

public class Main {

	public static void main(String[] args) {
		
		Double valor;
		Scanner ler = new Scanner(System.in);
		
		
		TContaBancaria conta;
		
		Banco listaContas = new Banco();
		
		char opcaoMenuPrincipal = 's';
		do {
			
			System.out.println("------------------------ Banco MagalhaesBank---------------------------");
			System.out.println();
			System.out.println("---------------------MENU PRINCIPAL------------------------------------");
			System.out.println("1: Criar conta");
			System.out.println("2: Movimentação de contas: Sacar,Depositar,transferir e ver saldo");
			System.out.println("3: Gerar Relatório geral das contas");
			System.out.println("4: Finalizar programa");
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");
			
			System.out.print("Digite uma das opções acima: ");
			int escolherOpcao = ler.nextInt();
			ler.nextLine();
			System.out.println("----------------------------------------------------------------------------");
			 switch (escolherOpcao) {
			   
				case 1: 
					char opcaoCriarConta = 'n';
					aa:
					do {
						System.out.println("Insira os dados abaixo solicitados para criar a conta: ");
						
						System.out.println();
						
						System.out.print("Digite o numero da Agência: ");	

						String numeroAgencia = ler.nextLine();
						
						int numeroConta = 0;
						
						boolean lerDadoNovamente = true;
						
						while(lerDadoNovamente) {
							
							try {
								
								System.out.print("Digite o numero da conta: ");		
								numeroConta = ler.nextInt();
									
							} catch (Exception e) {
									
								System.out.println("---------------------------------------------------------------------");
								System.out.println("Erro: Esse campo só aceita numeros. Erro interno: "+e.toString());
								System.out.println("Voltando ao menu principal...");
								System.out.println("---------------------------------------------------------------------");
								ler.next();
								System.out.print("clique na tecla p, após enter para prosseguir: ");
								ler.next();
								break aa;
								
							}
							
							if(listaContas.procurarConta(numeroConta) == null) {
								lerDadoNovamente = false;
							}else {
								System.out.println("Esse numero de conta já existe. Digite outro numero de conta.");
							}
							
						}

														
						ler.nextLine();
						System.out.print("Digite o nome do titular da conta: ");
						String nomeCliente = ler.nextLine();
						
						System.out.print("Digite o CPF: ");
						String CPF = ler.nextLine();
					
							
						System.out.print("Digite o valor inicial do deposito: ");
						valor = ler.nextDouble();
						
						conta = new TContaBancaria(nomeCliente, CPF, numeroConta, numeroAgencia,valor);
						boolean contaCriada = listaContas.criarConta(conta);
						if(contaCriada == true) { 
							System.out.println("-----------------------------------------------------------------");
							System.out.println("Conta criada com sucesso!!!");
							System.out.println(conta);
							}
						
						System.out.println("---------------------------------------------------------------------");
						
						System.out.println("---------------------------------------------------------------------");
						
						if(contaCriada == true) {
							System.out.print("Deseja criar outra conta: s/n: ");
							opcaoCriarConta = ler.next().charAt(0);
							ler.nextLine();
							System.out.println("---------------------------------------------------------------------");
							
						}else {
							System.out.println("Não é possível criar mais contas. Entre em contato com suporte.");
							System.out.print("clique na tecla p, após enter para prosseguir: ");
							ler.next();
							opcaoCriarConta = 'n';
							
							System.out.println("---------------------------------------------------------------------");
						}
						
						

					} while( opcaoCriarConta == 's');
					
					
					break;
				case 2: 
						
					char escolhaMovimentacoes = 'n';
					do {
						
						System.out.println("Digite o numero da conta para fazer o Saque/Deposito/Transferência: ");
						int numeroConta = ler.nextInt();
						
						TContaBancaria contaEncontrada = listaContas.procurarConta(numeroConta);
						
						if(contaEncontrada == null) {
							System.out.println("Conta não encontrada");
						} else {
							
							int opcaoMenuMovimentacao = 1;
							do {
								
								 System.out.println("----------MENU---------------------------------------------");
								  System.out.println("	1: Depositar");
								  System.out.println("	2: Sacar");
								  System.out.println("	3: Transferir");
								  System.out.println("	4: Imprimir Saldo");
								  System.out.println("	5: Sair");
								  
								   System.out.print("Informe a operação desejada conforme acima: 1, 2, 3, 4 ou 5: ");
								   int opcaoMovimentacoes = ler.nextInt();
								   switch (opcaoMovimentacoes) {
								   
										case 1: 
									solicitaValorDeposito(ler, contaEncontrada);
											
											break;
										case 2: 
											System.out.print("Digite o valor a ser sacado: ");
											double valorParaSacar = ler.nextDouble();
											contaEncontrada.saque(valorParaSacar);
											
											break;
										case 3: 
											System.out.print("Digite o valor a ser transferido: ");
											double valorParaTransferir = ler.nextDouble();
											System.out.print("Digite a conta para transferencia: ");
											TContaBancaria contaParaTransferencia = listaContas.procurarConta(ler.nextInt());
											contaEncontrada.transferirValor(valorParaTransferir, contaParaTransferencia);

											
											break;
										case 4: 
											System.out.println("-------------------------------------------------------------");
											System.out.println(contaEncontrada.toString());
											System.out.println("-------------------------------------------------------------");
											System.out.print("clique na tecla p, após enter para prosseguir: ");
											ler.next();
											

											break;
										case 5: 
											System.out.println("----------------------------------------------------");
											System.out.println("Voltando ao menu movimentações");
											System.out.println("----------------------------------------------------");
											opcaoMenuMovimentacao = 0;
											break;
					
										default:
											System.out.println("Opção digitada invalida!!!");
								   }
							   
								
							}while(opcaoMenuMovimentacao == 1);
							
							 
						}
									
						
						System.out.print("Deseja fazer outra movimentação: s/n: ");
						escolhaMovimentacoes = ler.next().charAt(0);
					}while(escolhaMovimentacoes == 's');
					
					break;
					
				case 3: 
					
					System.out.println("Lista de contas criadas:");
					listaContas.imprimirListaContas();
					System.out.print("clique na tecla p, após enter para prosseguir: ");
					ler.next();					
					
					break;
				case 4: 
					opcaoMenuPrincipal = 'n';

					break;
			
				default:
			
			 }
			
		}while(opcaoMenuPrincipal == 's');
	
		
		System.out.println();
		System.out.println("--------------------------Fim do programa----------------------------------");
				
		ler.close();
		

	}

	private static void solicitaValorDeposito(Scanner ler, TContaBancaria contaEncontrada) {
		System.out.print("Digite o valor a ser depositado: ");
		double valorParaDeposito = ler.nextDouble();
		contaEncontrada.deposito(valorParaDeposito);
	}

}
