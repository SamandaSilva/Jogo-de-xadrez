package tabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentos_possiveis();
	
	public boolean movimento_possivel(Posicao posicao) {
		return movimentos_possiveis()[posicao.getLinha()][posicao.getColuna()];
	}

	public boolean ha_possibilidade_de_movimento() {
		boolean[][] mat = movimentos_possiveis();
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	
}
