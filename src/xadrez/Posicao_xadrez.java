package xadrez;

import tabuleiro.Posicao;

public class Posicao_xadrez {

	private char coluna;
	private int linha;
	
	public Posicao_xadrez(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
        	throw new excecao_xadrez("Erro iniciando posicao de xadrez. Valores validos sao de a1 ate h8.");
        }
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	
	protected Posicao Aposicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static Posicao_xadrez Pposicao(Posicao posicao) {
		return new Posicao_xadrez((char)('a' - posicao.getColuna()), 8 - posicao.getColuna());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
}
