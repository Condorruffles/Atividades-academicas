//Alunos: Raphael Maurício, Romualdo Junior, Felipe Gabriel, Guilherme Felicíssimo

package jogoVelhaLPA;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[][] tab = new char[3][3];
		int rodada = 1;
		int fim = 0;
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
			System.out.println("Digite a linha (1 a 3):");
			int linha = sc.nextInt();
			System.out.println("Digite a coluna (1 a 3):");
			int coluna = sc.nextInt();

			if (linha > 0 && linha <= tab.length && coluna > 0 && coluna <= tab.length
					&& tab[linha - 1][coluna - 1] == ' ') {
				tab[linha - 1][coluna - 1] = jogador;
				if (rodada >= 5) {
					fim = validarTriunfo(tab, rodada);
				}
				if (fim == 0) {
					rodada++;
				} else if (fim == 1) {
					exibirTabuleiro(tab);
					System.out.println("Parabéns jogador "+ jogador + ", VOCÊ VENCEU!!");
				} else {
					exibirTabuleiro(tab);
					System.out.println("Deu velha!");
				}
			} else {
				System.out.printf("Jogada inválida!\njogue novamente.\n");
			}
		} while (fim == 0);
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

	public static int validarTriunfo(char[][] tabuleiro, int rodada) {
		for (int i = 0; i < tabuleiro.length; i++) {
			if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][0] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
				return 1;
			}
			if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[0][i] == tabuleiro[2][i] && tabuleiro[0][i] != ' ') {
				return 1;
			}
		}
		if (tabuleiro[1][1] != ' ') {
			if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
				return 1;
			}
			if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
				return 1;
			}
		}
		if (rodada == 9) {
			return 2;
		}
		return 0;
	}
}
