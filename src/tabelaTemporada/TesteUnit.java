package tabelaTemporada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteUnit {
	Placar acess = new Placar();

	@Test
	void testQuantidade_jogos_placar() {
		// compara se a quantidade de jogos é equivalente a quantidade passada no placar!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdPlacar());
	}
	
	@Test
	void testQuantidade_jogos_quebrasMin() {
		// compara se a quantidade de jogos é equivalente a sequência do mínimo!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdQuebrasMin());
	}
	
	@Test
	void testQuantidade_jogos_quebrasMax() {
		// compara se a quantidade de jogos é equivalente a sequência do máximo!
		assertTrue(acess.testeQtdJogos() == acess.testeQtdQuebrasMax());
	}
	
	@Test
	void testMax() {
		// compara se o valor máximo passado no placar é o mesmo do máximo salvo
		assertTrue(acess.testeQtdPlacarMax() == acess.testeUltimoMax());
	}
	
	@Test
	void testMin() {
		// compara se o valor mínimo passado no placar é o mesmo do mínimo salvo
		assertTrue(acess.testeQtdPlacarMin() == acess.testeUltimoMin());
	}

}
