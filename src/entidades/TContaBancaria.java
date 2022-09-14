package entidades;

public class TContaBancaria {
	
	private String nomeCliente;
	private String CPF;
	private int numeroConta;
	private String agencia;
	private Double saldo = 0.0;
	
	public TContaBancaria(String nomeCliente, String CPF, int numeroConta, String agencia, Double valorInicial) {
		
		this.nomeCliente = nomeCliente;
		this.CPF = CPF;
		this.numeroConta = numeroConta;
		this.agencia = agencia;	
		this.saldo = valorInicial;
		
	}

	public TContaBancaria(TContaBancaria conta) {
		this.nomeCliente = conta.nomeCliente;
		this.CPF = conta.CPF;
		this.numeroConta = conta.numeroConta;
		this.agencia = conta.agencia;	
		this.saldo = conta.saldo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCPF() {
		return CPF;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	
	public void saque(Double valor) {
		saldo -= valor;
	}
	
	public void transferirValor(Double valor, TContaBancaria conta) {
		saque(valor);
		conta.deposito(valor);
		
	}
	
	public String toString() {
		
		return "Agência: "+ agencia + " - Conta: "+ numeroConta+" Cliente: "+nomeCliente+" - Saldo: "+saldo;
		
	}


}
