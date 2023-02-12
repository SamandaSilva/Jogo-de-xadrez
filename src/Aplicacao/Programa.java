package Aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_xadrez;
import xadrez.excecao_xadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Partida_de_xadrez partida = new Partida_de_xadrez();
		List<Peca_de_xadrez> capturadas = new ArrayList<>();
		
		while (true) {
			try {
				UI.limpar_tela();
				UI.printPartida(partida, capturadas);
				System.out.println();
				System.out.print("Origem: ");
				Posicao_xadrez origem = UI.ler_posicao_do_xadrez(sc);

				boolean[][] movimentos_possiveis = partida.movimentos_possiveis(origem);
				UI.limpar_tela();
				UI.printTabuleiro(partida.getpecas(), movimentos_possiveis);
				
				System.out.println();
				System.out.println();
				System.out.print("Destino: ");
				Posicao_xadrez destino = UI.ler_posicao_do_xadrez(sc);

				Peca_de_xadrez peca_capturada = partida.performa_partida(origem, destino);
			
				if(peca_capturada != null) {
					capturadas.add(peca_capturada);
				}
				
			} catch (excecao_xadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
