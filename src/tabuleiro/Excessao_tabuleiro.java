package tabuleiro;



public class Excessao_tabuleiro extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public Excessao_tabuleiro(String msg) {
		super(msg);
	}
}
