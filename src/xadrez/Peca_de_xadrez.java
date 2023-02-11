package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class Peca_de_xadrez extends Peca {

	private Cor cor;

	public Peca_de_xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	protected boolean peca_adversaria(Posicao posicao) {
		Peca_de_xadrez p = (Peca_de_xadrez)getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
	
}
