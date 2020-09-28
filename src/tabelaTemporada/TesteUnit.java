package tabelaTemporada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteUnit {
	Placar acess = new Placar();

	@Test
	void testQuantidade_jogos_placar() {
		// compara se a quantidade de jogos � equivalente a quantidade passada no placar!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdPlacar());
	}
	
	@Test
	void testQuantidade_jogos_quebrasMin() {
		// compara se a quantidade de jogos � equivalente a sequ�ncia do m�nimo!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdQuebrasMin());
	}
	
	@Test
	void testQuantidade_jogos_quebrasMax() {
		// compara se a quantidade de jogos � equivalente a sequ�ncia do m�ximo!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdQuebrasMax());
	}
	
	@Test
	void testMax() {
		// compara se o valor m�ximo passado no placar � o mesmo do m�ximo salvo
		assertTrue(acess.testeQtdPlacarMax() == acess.testeUltimoMax());
	}
	
	@Test
	void testMin() {
		// compara se o valor m�nimo passado no placar � o mesmo do m�nimo salvo
		assertTrue(acess.testeQtdPlacarMin() == acess.testeUltimoMin());
	}

}
