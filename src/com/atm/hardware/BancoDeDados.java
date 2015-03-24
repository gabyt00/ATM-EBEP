package com.atm.hardware;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.atm.software.ContaCorrente;
import com.atm.software.Usuario;

public class BancoDeDados {
	
	List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
	
	public BancoDeDados() {
		Usuario titularC1 = new Usuario("José Maria", "02525-2");
		ContaCorrente c1 = new ContaCorrente(
				new BigDecimal("1000.0"), 12345, 54321, titularC1, new BigDecimal("1000.0") );

		Usuario titularC2 = new Usuario("José Benedito", "02525-2");
		ContaCorrente c2 = new ContaCorrente(
				new BigDecimal("2000.0"), 1245, 54421, titularC2, new BigDecimal("2000.0") );
		
		Usuario titularC3 = new Usuario("José Ferreira", "02525-2");
		ContaCorrente c3 = new ContaCorrente(
				new BigDecimal("1220.0"), 12415, 14421, titularC3, new BigDecimal("3000.0") );
		
		contas.add(c1);
	}
	
	private ContaCorrente getConta(Integer numeroDaConta) {
		for(ContaCorrente conta : contas) {
			if(numeroDaConta.equals(conta.getNumeroConta())) {
				return conta;
			}
		}
		return null;
	}
	
	public boolean autenticaUsuario(Integer numeroConta, Integer userPin) {
		ContaCorrente conta = getConta(numeroConta);
		return (userPin.equals(conta.getPinCode()));
			
	}

	public BigDecimal getSaldoDisponivel(Integer numDaConta) {
		return getConta(numDaConta).getSaldoDisponivel();
	}

	public BigDecimal getSaldoTotal(int numDaConta) {
		return getConta(numDaConta).getSaldoTotal();
	}

	// credita uma quantia a Conta com o número de conta especificado
	public void credita(int numDaConta, BigDecimal quantia) {
		getConta(numDaConta).credita(quantia);
	}

	// debita uma quantidade da Conta com o número de conta especificado
	public void debita(int numDaConta, BigDecimal quantia) {
		getConta(numDaConta).debita(quantia);
	}
	
	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		
		ContaCorrente conta  = bd.getConta(12345);
		
		if(conta != null ) {
			System.out.println("Conta com saldo de " + conta.getSaldoTotal() );
		}else {
			System.out.println("Não existe conta com este numero!");
		}
	}

}
