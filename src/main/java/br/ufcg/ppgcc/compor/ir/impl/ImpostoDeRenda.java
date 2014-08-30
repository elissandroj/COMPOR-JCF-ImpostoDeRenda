package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.FontePagadora;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento {

	private List<Titular> titulares = new ArrayList<Titular>();
	private List<FontePagadora> fontes = new ArrayList<FontePagadora>();
	private Map<Titular,List<FontePagadora>> mapaFontes = new HashMap<Titular,List<FontePagadora>>();
	
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
		mapaFontes.put(titular, new ArrayList<FontePagadora>());	
	}

	public List<Titular> listarTitulares() {
		return titulares;
	}

	public void criarFontePagadora(Titular titular, FontePagadora 	fonte)  throws ExcecaoImpostoDeRenda {
		if(fonte.getNome() == null){
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}
		if(fonte.getCpfCnpj() == null){
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		}
		if(fonte.getRendimentoRecebidos() == 0){
			throw new ExcecaoImpostoDeRenda("O campo rendimentos recebidos é obrigatório");
		}
		if(fonte.getRendimentoRecebidos() < 0){
			throw new ExcecaoImpostoDeRenda("O campo rendimentos recebidos deve ser maior que zero");
		}
		
		if((fonte.getCpfCnpj().length() != 11) && (fonte.getCpfCnpj().length() != 18)) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é inválido");
		}
		List<FontePagadora> fontesDoTitular = mapaFontes.get(titular);
		if (fontesDoTitular == null) {
			throw new ExcecaoImpostoDeRenda("Titular não cadastrado");
		}
		
		fontesDoTitular.add(fonte);
	}

	public List<FontePagadora> listarFontes(Titular titular) {
		return mapaFontes.get(titular);
		
	}
	
	
	
}