package br.ufcg.ppgcc.compor.ir;

import static br.ufcg.ppgcc.compor.ir.FontePagadoraHelper.criarFontePagadoraPorRenda;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DeclaracaoCompletaTest {

	private FachadaExperimento fachada;

	@Before
	public void iniciar() {
		fachada = FachadaHelper.criarFachada();
	}

	@Test
	public void T_04_01_calculoImpostoIsento() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		cadastrarCalcularImpostoDevido(0, titular1, 15000);

		Titular titular2 = TitularHelper.criarTitularMinimo();
		cadastrarCalcularImpostoDevido(0, titular2, 19000);

		Titular titular3 = TitularHelper.criarTitularPadrao2();
		cadastrarCalcularImpostoDevido(0, titular3, 5000, 10000);
	}

	@Test
	public void T_04_02_calculoImpostoFaixa2() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		cadastrarCalcularImpostoDevido(0, titular1, 20000);

		Titular titular2 = TitularHelper.criarTitularMinimo();
		cadastrarCalcularImpostoDevido(0, titular2, 25000);

		Titular titular3 = TitularHelper.criarTitularPadrao2();
		cadastrarCalcularImpostoDevido(0, titular3, 15000, 14000);
	}

	@Test
	public void T_04_03_calculoImpostoFaixa3() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		cadastrarCalcularImpostoDevido(0, titular1, 30000);

		Titular titular2 = TitularHelper.criarTitularMinimo();
		cadastrarCalcularImpostoDevido(0, titular2, 35000);

		Titular titular3 = TitularHelper.criarTitularPadrao2();
		cadastrarCalcularImpostoDevido(0, titular3, 15000, 24000);
	}

	@Test
	public void T_04_04_calculoImpostoFaixa4() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		cadastrarCalcularImpostoDevido(0, titular1, 40000);

		Titular titular2 = TitularHelper.criarTitularMinimo();
		cadastrarCalcularImpostoDevido(0, titular2, 45000);

		Titular titular3 = TitularHelper.criarTitularPadrao2();
		cadastrarCalcularImpostoDevido(0, titular3, 15000, 34000);
	}

	@Test
	public void T_04_05_calculoImpostoFaixa5() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		cadastrarCalcularImpostoDevido(0, titular1, 51000);

		Titular titular2 = TitularHelper.criarTitularMinimo();
		cadastrarCalcularImpostoDevido(0, titular2, 100000);

		Titular titular3 = TitularHelper.criarTitularPadrao2();
		cadastrarCalcularImpostoDevido(0, titular3, 300000, 500000,
				200000);

	}
	
	@Test
	public void T_04_06_calculoImpostoIsentoComDependente() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		Dependente dependente1 = DependenteHelper.criarDependentePadrao1();
		cadastrarCalcularImpostoDevido(0, titular1, 1000, dependente1);

		Titular titular2 = TitularHelper.criarTitularPadrao2();
		Dependente dependente2 = DependenteHelper.criarDependentePadrao2();
		cadastrarCalcularImpostoDevido(0, titular2, 15000, dependente2);

		Titular titular3 = TitularHelper.criarTitularMinimo();
		Dependente dependente3 = DependenteHelper.criarDependentePadrao3();
		Dependente dependente4 = DependenteHelper.criarDependentePadrao4();
		cadastrarCalcularImpostoDevido(0, titular3, 19000, dependente3, dependente4);
	}

	@Test
	public void T_04_07_calculoImpostoFaixa2ComDependente() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		Dependente dependente1 = DependenteHelper.criarDependentePadrao1();
		cadastrarCalcularImpostoDevido(0, titular1, 20000, dependente1);

		Titular titular2 = TitularHelper.criarTitularPadrao2();
		Dependente dependente2 = DependenteHelper.criarDependentePadrao2();
		cadastrarCalcularImpostoDevido(0, titular2, 25000, dependente2);

		Titular titular3 = TitularHelper.criarTitularMinimo();
		Dependente dependente3 = DependenteHelper.criarDependentePadrao3();
		Dependente dependente4 = DependenteHelper.criarDependentePadrao4();
		cadastrarCalcularImpostoDevido(0, titular3, 29000, dependente3, dependente4);
	}

	@Test
	public void T_04_08_calculoImpostoFaixa3ComDependente() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		Dependente dependente1 = DependenteHelper.criarDependentePadrao1();
		cadastrarCalcularImpostoDevido(0, titular1, 30000, dependente1);

		Titular titular2 = TitularHelper.criarTitularPadrao2();
		Dependente dependente2 = DependenteHelper.criarDependentePadrao2();
		cadastrarCalcularImpostoDevido(0, titular2, 35000, dependente2);

		Titular titular3 = TitularHelper.criarTitularMinimo();
		Dependente dependente3 = DependenteHelper.criarDependentePadrao3();
		Dependente dependente4 = DependenteHelper.criarDependentePadrao4();
		cadastrarCalcularImpostoDevido(0, titular3, 39000, dependente3, dependente4);		
	}
	
	@Test
	public void T_04_09_calculoImpostoFaixa4ComDependente() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		Dependente dependente1 = DependenteHelper.criarDependentePadrao1();
		cadastrarCalcularImpostoDevido(0, titular1, 40000, dependente1);

		Titular titular2 = TitularHelper.criarTitularPadrao2();
		Dependente dependente2 = DependenteHelper.criarDependentePadrao2();
		cadastrarCalcularImpostoDevido(0, titular2, 45000, dependente2);

		Titular titular3 = TitularHelper.criarTitularMinimo();
		Dependente dependente3 = DependenteHelper.criarDependentePadrao3();
		Dependente dependente4 = DependenteHelper.criarDependentePadrao4();
		cadastrarCalcularImpostoDevido(0, titular3, 49000, dependente3, dependente4);		
	}

	@Test
	public void T_04_10_calculoImpostoFaixa5ComDependente() {
		Titular titular1 = TitularHelper.criarTitularPadrao();
		Dependente dependente1 = DependenteHelper.criarDependentePadrao1();
		cadastrarCalcularImpostoDevido(0, titular1, 51000, dependente1);

		Titular titular2 = TitularHelper.criarTitularPadrao2();
		Dependente dependente2 = DependenteHelper.criarDependentePadrao2();
		cadastrarCalcularImpostoDevido(0, titular2, 100000, dependente2);

		Titular titular3 = TitularHelper.criarTitularMinimo();
		Dependente dependente3 = DependenteHelper.criarDependentePadrao3();
		Dependente dependente4 = DependenteHelper.criarDependentePadrao4();
		cadastrarCalcularImpostoDevido(0, titular3, 1000000, dependente3, dependente4);		
	}

	private void cadastrarCalcularImpostoDevido(double impostoDevido,
			Titular titular, int... rendas) {

		fachada.criarNovoTitular(titular);

		for (int renda : rendas) {
			FontePagadora fonte = criarFontePagadoraPorRenda(renda);
			fachada.criarFontePagadora(titular, fonte);
		}

		Resultado completo = fachada.declaracaoCompleta(titular);
		assertEquals(impostoDevido, completo.getImpostoDevido(), 0.1);
	}

	private void cadastrarCalcularImpostoDevido(double impostoDevido,
			Titular titular, int renda, Dependente... dependentes) {

		fachada.criarNovoTitular(titular);

		FontePagadora fonte = criarFontePagadoraPorRenda(renda);
		fachada.criarFontePagadora(titular, fonte);
		
		for (Dependente dependente : dependentes) {
			fachada.criarDependente(titular, dependente);
		}

		Resultado completo = fachada.declaracaoCompleta(titular);
		assertEquals(impostoDevido, completo.getImpostoDevido(), 0.1);
	}

}
