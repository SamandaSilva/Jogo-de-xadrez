package xadrez;

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
	
	private void coordenadas(char coluna, int linha, Peca_de_xadrez peca) {
		tabuleiro.lugar_da_peca(peca, new Posicao_xadrez(coluna, linha).Aposicao());
	}
	
	private void iniciarpartida() {
		coordenadas('b', 6, new Torre(tabuleiro, Cor.branco));
		coordenadas('e', 8, new Rei(tabuleiro, Cor.preto));
		coordenadas('e', 1, new Rei(tabuleiro, Cor.preto));

	}
}
