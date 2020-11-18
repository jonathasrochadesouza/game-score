package tabelaTemporada;

import java.util.ArrayList;
import java.util.Collections;
public class Placar {
	private int qtdQuebrasMin; // quantidade de quebras de recorde
	private int qtdQuebrasMax; // quantidade de quebras de recorde
	private int qualJogo; // salva o jogo passado no 'Main', na opção de editar o placar
	private int valorMin; // valor minímo
	private int valorMax; // valor máximo
	// private int lastValue;
	
	private ArrayList<Integer> jogo = new ArrayList<>(); // jogo
	private ArrayList<Integer> placar = new ArrayList<>(); // placar
	private ArrayList<Integer> minRecor = new ArrayList<>(); // recorde minímo
	private ArrayList<Integer> maxRecor = new ArrayList<>(); // recorde máximo
	private ArrayList<Integer> qMin = new ArrayList<>(); // qtd de quebras de recorde minímo
	private ArrayList<Integer> qMax = new ArrayList<>(); // qtd de quebras de recorde máximo
	private ArrayList<Integer> id = new ArrayList<>(); // id -- faz a contagem de jogos cadastrados
	
	public Placar() {
		this.jogosInicio();
		this.placarIncio();
		this.recordeMinInicio();
		this.recordeMaxInicio();
		this.valoresMinInicio();
		this.valoresMaxInicio();
		
		// qtdQuebrasMin = 1;
		// qtdQuebrasMax = 1;
		// valorMin = 10;
		// valorMax = 24;
	}
	
	// jogos já definidos
	private void jogosInicio() {
		for (int i = 0; i < 4; i++) {
			this.jogo.add(i+1);
			this.id.add(i);
		}
	}
	
	// placar  já definido
	private void placarIncio() {
		this.placar.add(12);
		this.placar.add(24);
		this.placar.add(10);
		this.placar.add(24);
		
		
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				valorMin = this.placar.get(0); // minímo inicia com primeiro valro
			} if (this.placar.get(i) < Collections.min(this.placar)) { // this.placar.get(i) < Collections.min(this.placar)
				valorMin = placar.get(i);
				qtdQuebrasMin++; // acrescenta 1 a quebra de recordes minímo
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				valorMax = this.placar.get(0); // máximo inicia com primeiro valro
			} if (this.placar.get(i) > Collections.max(this.placar)) {
				valorMax = placar.get(i);
				qtdQuebrasMax++; // acrescenta 1 a quebra de recordes máximo
			}
		}
	}
	
	// quantidade de quebras de recorde  já definido
	private void recordeMinInicio() {
		this.qMin.add(0);
		this.qMin.add(0);
		this.qMin.add(1);
		this.qMin.add(1);
	}
		
	// quantidade de quebras de recorde  já definido
	private void recordeMaxInicio() {
		this.qMax.add(0);
		this.qMax.add(1);
		this.qMax.add(1);
		this.qMax.add(1);
	}
	
	// valores minímos na temporada
	private void valoresMinInicio() {
		this.minRecor.add(12);
		this.minRecor.add(12);
		this.minRecor.add(10);
		this.minRecor.add(10);
	}
		
	// valores máximo na temporada
	private void valoresMaxInicio() {
		this.maxRecor.add(12);
		this.maxRecor.add(24);
		this.maxRecor.add(24);
		this.maxRecor.add(24);
	}
	
	// menu
	public void getMenu() {
		System.out.println("\nMaria, escolha o que deseja:\n");
		System.out.println("1 - Atualizar novo placar;");
		System.out.println("2 - Consultar tabela atual;");
		System.out.println("3 - Editar último placar;");
		System.out.println("4 - Sair.");
		System.out.print("\nDigite a opção desejada: ");
	}

	// adiciona novo placar
	public void setPlacar(int value) {
		this.placar.add(value);
		
		// qtdQuebrasMin = qtdQuebrasMin +1; 
		
		// valor minímo
		if  (Collections.min(this.placar) < Collections.min(this.minRecor)) {
			this.qMin.add(Collections.max(this.qMin)+1);
		} else {
			this.qMin.add(Collections.max(this.qMin));
		}

		// valor máximo
		if  (Collections.max(this.placar) > Collections.max(this.maxRecor)) {
			this.qMax.add(Collections.max(this.qMax)+1);
		} else {
			this.qMax.add(Collections.max(this.qMax));
		}
		
		minRecor.add(Collections.min(this.placar));
		maxRecor.add(Collections.max(this.placar));
		
		this.jogo.add(jogo.size()+1); // sempre que este método for chamado adiciona mais 1 ao "jogo"
		this.id.add(id.size()); // sempre que este método for chamado adiciona mais 1 ao "id" 
	}
	
	// Qual será o próximo jogo? se ouver!
	public int nextJogo() {
		return id.size() + 1;
	}
	
	// quantidade quebra recorde min
	public int quebraMin() {
		return Collections.max(this.qMin);
	}
	
	// quantidade quebra recorde max
	public int quebraMax() {
		return Collections.max(this.qMax);
	}
	
	// quantidade quebra recorde total
	public int quebraTotal() {
		return quebraMax() + quebraMin();
	}
	
	// editar placar do último jogo
	public void setEditar(int j /*jogo*/, int p /*placar*/) {
		
		this.placar.set(j, p);
		
		// atualizações
		
		if (this.qMin.get(j) != this.qMin.get(j-1)) { // se atualizar aqui (subtraia 1)
			this.qMin.set(j, Collections.max(this.qMin) - 1);
		} else if (this.maxRecor.get(j) == this.maxRecor.get(j-1)) { // se atualizar aqui (some 1)
			this.qMax.set(j, Collections.max(this.qMax) + 1);
		}
		
		if (this.qMax.get(j) != this.qMax.get(j-1) && this.maxRecor.get(j) < this.maxRecor.get(j-1)) { // se atualizar aqui (retorne ao valor anterior)
			this.qMax.set(j, this.qMin.get(j - 1));
		} 
		
		// soma mais 1 aqui!
		if (this.placar.get(j) == Collections.min(this.placar) && this.qMin.get(j) == this.qMin.get(j-1)) {
			this.qMin.set(j, Collections.max(this.qMin) + 1);
		}
		/*
		// soma mais 1 aqui!
		if (this.placar.get(j) == Collections.max(this.placar) && this.qMax.get(j) == this.qMax.get(j-1)) {
			this.qMax.set(j, Collections.max(this.qMax) + 1);
		}
		*/
		
		minRecor.set(j, Collections.min(this.placar));
		maxRecor.set(j, Collections.max(this.placar));
		
	}
	
	// retorna a quantidade de jogos
	public int getQtdMinJogos() {
		return Collections.min(this.jogo) + 1 /* 0 + 1 */;
	}
	
	// retorna a quantidade de jogos
	public int getQtdMaxJogos() {
		return Collections.max(this.jogo);
	}
	
	// qual jogo será editado (último jogo)
	public int getQualJogo() {
		return this.placar.size() - 1;
	}
	
	// tabela
	public void getPlacar() {
		System.out.printf("%n%6s%18s%20s%20s%20s%20s%n", "Jogo", "Placar", "Temporada(Mín)", "Temporada(Máx)", "Recorde(Mín)", " Recorde(Máx)");
		for(int i = 0; i < jogo.size(); i++) {
			System.out.printf("%n%6d", jogo.get(i));
			System.out.printf("%20d", placar.get(i));
			System.out.printf("%23d", minRecor.get(i));
			System.out.printf("%31d", maxRecor.get(i));
			System.out.printf("%32d", qMin.get(i));
			System.out.printf("%31d", qMax.get(i));
			// System.out.println("\n");
		}
		System.out.println("\n\nDescrição: ");
		
		// plural ou singular! (max)
		if (this.quebraMax() > 1) {
			System.out.println("Quebras no recorde máximo: " + quebraMax() + " vezes");
		} else {
			System.out.println("Quebra no recorde máximo: " + quebraMax() + " vez");
		}
		
		// plural ou singular! (min)
		if (this.quebraMin() > 1) {
			System.out.println("Quebras no recorde mínimo: " + quebraMin() + " vezes");
		} else {
			System.out.println("Quebra no recorde mínimo: " + quebraMin() + " vez");
		}
		
		// plural ou singular! (min)
		if (this.quebraTotal() > 1) {
			System.out.print("Quebras no recorde total: " + quebraTotal() + " vezes");
		} else {
			System.out.print("Quebra no recorde total: " + quebraTotal() + " vezes");
		}
	}
	
	// retorna a quantidade de jogos
	public int testeQtdJogos() {
		return this.jogo.size();
	}
	
	// retorna a quantidade de placares
	public int testeQtdPlacar() {
		return this.placar.size();
	}
	
	// retorna a quantidade de quebras(Mín)
	public int testeQtdQuebrasMin() {
		return this.qMin.size();
	}
	
	// retorna a quantidade de quebras(Max)
	public int testeQtdQuebrasMax() {
		return this.qMax.size();
	}
	
	// retorna o valor máximo do placar
	public int testeQtdPlacarMax() {
		return Collections.max(this.placar);
	}
	
	// retorna o valor mínimo do placar
	public int testeQtdPlacarMin() {
		return Collections.min(this.placar);
	}
	
	// retorna a quantidade de quebras(Max)
	public int testeUltimoMax() {
		return Collections.max(this.maxRecor);
	}
	
	// retorna a quantidade de quebras(Max)
	public int testeUltimoMin() {
		return Collections.min(this.minRecor);
	}
		
	public void teste() { // método de testes
		for (int i = 0; i < this.id.size(); i++) {
			// System.out.print(this.jogo.get(i) + " ");
			// System.out.print(this.id.get(i) + " ");
			// System.out.print(this.id.size() + " ");
			// System.out.print(this.placar.get(i) + " ");
			// System.out.print(this.qMin.get(i) + " ");
			// System.out.print(this.qMax.get(i) + " ");
			// System.out.print(this.minRecor.get(i) + " ");
			// System.out.print(this.maxRecor.get(i) + " ");
		}
	}
}
