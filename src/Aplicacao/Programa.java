package Aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_xadrez;
import xadrez.excecao_xadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Partida_de_xadrez partida = new Partida_de_xadrez();

		while (true) {
			try {
				UI.limpar_tela();
				UI.printTabuleiro(partida.getpecas());
				System.out.println();
				System.out.print("Origem: ");
				Posicao_xadrez origem = UI.ler_posicao_do_xadrez(sc);

				System.out.println();
				System.out.print("Destino: ");
				Posicao_xadrez destino = UI.ler_posicao_do_xadrez(sc);

				Peca_de_xadrez peca_capturada = partida.performa_partida(origem, destino);
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
