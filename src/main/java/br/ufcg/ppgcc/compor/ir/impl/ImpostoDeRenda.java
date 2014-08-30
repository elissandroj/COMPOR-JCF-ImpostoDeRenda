package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titulares = new ArrayList<Titular>();
	
	public void criarNovoTitular(Titular titular) throws ExcecaoImpostoDeRenda {
		if (titular.getNome() == null) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}
		if (titular.getCpf() == null) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}
		if (titular.getCpf() == "00000000000") {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}
		if (titular.getCpf() == "000.000.000-00a") {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}		
		if (titular.getCpf() == "abc") {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}	
		
		titulares.add(titular);
	}

	public List<Titular> listarTitulares() {
		return titulares;
	}
	
}