package xadrez;

import tabuleiro.Peca;
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

	public Peca_de_xadrez[][] getpecas() {
		Peca_de_xadrez[][] mat = new Peca_de_xadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (Peca_de_xadrez) tabuleiro.peca(i, j);

			}
		}
		return mat;
	}
	
	public Peca_de_xadrez performa_partida(Posicao_xadrez posicao_origem, Posicao_xadrez posicao_destino) {
		Posicao origem = posicao_origem.Aposicao();
		Posicao destino = posicao_destino.Aposicao();
		validar_posicao_da_peca(origem);
		validar_posicao_destino(origem, destino);
		Peca captura_de_peca = mover_peca(origem, destino);
		return (Peca_de_xadrez)captura_de_peca;
	}

	private Peca mover_peca(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca peca_capturada = tabuleiro.removerPeca(destino);
		tabuleiro.lugar_da_peca(p, destino);
		return peca_capturada;
	}
	
	private void validar_posicao_da_peca(Posicao posicao) {
		if(!tabuleiro.tem_a_peca(posicao)) {
			throw new excecao_xadrez("nao existe peca nessa posicao");
		}
		if(!tabuleiro.peca(posicao).ha_possibilidade_de_movimento()) {
			throw new excecao_xadrez("nao existem movimentos possiveis para a peca escolhida");
		}
	}
	
	private void validar_posicao_destino(Posicao origem, Posicao destino) {
		if(!tabuleiro.peca(origem).movimento_possivel(destino)) {
			throw new excecao_xadrez("A peca escolhida nao pode se mover para a posicao de destino.");
		}
	}
	
	private void coordenadas(char coluna, int linha, Peca_de_xadrez peca) {
		tabuleiro.lugar_da_peca(peca, new Posicao_xadrez(coluna, linha).Aposicao());
	}

	private void iniciarpartida() {
		coordenadas('c', 1, new Torre(tabuleiro, Cor.branco));
		coordenadas('c', 2, new Torre(tabuleiro, Cor.branco));
		coordenadas('d', 2, new Torre(tabuleiro, Cor.branco));
		coordenadas('e', 2, new Torre(tabuleiro, Cor.branco));
		coordenadas('e', 1, new Torre(tabuleiro, Cor.branco));
		coordenadas('d', 1, new Rei(tabuleiro, Cor.branco));

		coordenadas('c', 7, new Torre(tabuleiro, Cor.preto));
		coordenadas('c', 8, new Torre(tabuleiro, Cor.preto));
		coordenadas('d', 7, new Torre(tabuleiro, Cor.preto));
		coordenadas('e', 7, new Torre(tabuleiro, Cor.preto));
		coordenadas('e', 8, new Torre(tabuleiro, Cor.preto));
		coordenadas('d', 8, new Rei(tabuleiro, Cor.preto));
	}
}
