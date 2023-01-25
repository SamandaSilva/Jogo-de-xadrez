package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class Partida_de_xadrez {

	private Tabuleiro tabuleiro;
	
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		iniciarpartida();
	}
	
	public Peca_de_xadrez[][] getpecas(){
		Peca_de_xadrez[][] mat = new Peca_de_xadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (Peca_de_xadrez)  tabuleiro.peca(i, j);
			
			}
		}
		return mat;
	}
	
	private void iniciarpartida() {
		tabuleiro.lugar_da_peca(new Torre(tabuleiro, Cor.branco), new Posicao(2, 1));
		tabuleiro.lugar_da_peca(new Rei(tabuleiro, Cor.preto), new Posicao(0, 4));
		tabuleiro.lugar_da_peca(new Rei(tabuleiro, Cor.preto), new Posicao(7, 4));

	}
}
