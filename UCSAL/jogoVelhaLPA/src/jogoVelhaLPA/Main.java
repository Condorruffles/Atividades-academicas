//Alunos: Raphael Maurício, Romualdo Júnior, Felipe Gabriel, Guilherme Felicíssimo

package jogoVelhaLPA;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[][] tab = new char[3][3];
		int rodada = 1;
		boolean fim = false;
		char jogador;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				tab[i][j] = ' ';
			}
		}

		do {
			if (rodada % 2 == 0) {
				jogador = 'O';
			} else {
				jogador = 'X';
			}
			System.out.printf("--- Jogo da velha ----\nRodada: %d\nJogador: %c\n\n", rodada, jogador);
			exibirTabuleiro(tab);
			System.out.println("Digite a linha:");
			int linha = sc.nextInt();
			System.out.println("Digite a coluna:");
			int coluna = sc.nextInt();

			if (linha > 0 && linha <= tab.length && coluna > 0 && coluna <= tab.length
					&& tab[linha - 1][coluna - 1] == ' ') {
				tab[linha - 1][coluna - 1] = jogador;
				if (rodada >= 5) {
					fim = validarTriunfo(tab);
				}
				if (fim == false) {
					rodada++;
				} else {
					exibirTabuleiro(tab);
					System.out.printf("Parabéns jogador %c, VOCÊ VENCEU!!\n", jogador);

				}
			} else {
				System.out.printf("Jogada inválida!\njogue novamente.\n");
			}
		} while (fim == false);
	}

	public static void exibirTabuleiro(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				if (!(j + 1 == tabuleiro.length)) {
					System.out.print(tabuleiro[i][j] + " | ");
				} else {
					System.out.println(tabuleiro[i][j]);
				}
			}
			if (!(i + 1 == tabuleiro.length)) {
				System.out.println("---------");
			}
		}
	}

	public static boolean validarTriunfo(char[][] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
				return true;
			}
			if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ') {
				return true;
			}
		}
		if (tabuleiro[1][1] != ' ') {
			if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
				return true;
			}
			if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
				return true;
			}
		}
		return false;
	}
}
