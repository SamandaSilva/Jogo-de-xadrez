package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public class Peca_de_xadrez extends Peca {

	private Cor cor;

	public Peca_de_xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	
}
