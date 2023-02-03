package Aplicacao;

import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_xadrez;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Partida_de_xadrez partida = new Partida_de_xadrez();

		while (true) {
			
				UI.limpar_tela();
				UI.printTabuleiro(partida.getpecas());
				System.out.println();
				System.out.print("Origem: ");
				Posicao_xadrez origem = UI.ler_posicao_do_xadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				Posicao_xadrez destino = UI.ler_posicao_do_xadrez(sc);

	            Peca_de_xadrez peca_capturada = partida.performa_partida(origem, destino);
				
			
		}
	}

}
