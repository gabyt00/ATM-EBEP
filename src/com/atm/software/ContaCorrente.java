package com.atm.software;

import java.math.BigDecimal;

public class ContaCorrente {
	
	private BigDecimal saldoDisponivel; // dinheiro disp. p/ saque
	private Integer numeroConta; // número da conta
	private Integer pinCode; // PIN para autenticação
	private Usuario titular; //Usuário titular da conta
	private BigDecimal saldoTotal; //dinheiro disponivel + depositos pendentes;
	
	public ContaCorrente(BigDecimal saldoDisponivel, Integer numeroConta,
			Integer pinCode, Usuario titular, BigDecimal saldoTotal) {
		super();
		this.saldoDisponivel = saldoDisponivel;
		this.numeroConta = numeroConta;
		this.pinCode = pinCode;
		this.titular = titular;
		this.saldoTotal = saldoTotal;
	}
	
	// determina se o PIN especificado pelo usuário corresponde ao PIN  em conta 
	public boolean validaPIN(Integer usuarioPin) {
		return (usuarioPin.equals(this.pinCode));
	}
	
	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}
	
	public BigDecimal getSaldoDisponivel() {
		return saldoDisponivel;
	}
	
	//  credita uma quantia a conta
	public void credita(BigDecimal quantia) {
		saldoTotal = saldoTotal.add(quantia);
	}
	
	public void debita(BigDecimal valor) {
		this.saldoDisponivel = saldoDisponivel.subtract(valor); // subtrai do saldo disp.
		this.saldoTotal = saldoTotal.subtract(valor); // subtrai do saldo total
	}
	/* 123 testando
	 * 
	 */
	public Integer getNumeroConta() {
		return numeroConta;
	}
	
	public Integer getPinCode() {
		return pinCode;
	}

}
