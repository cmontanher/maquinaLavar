// desafio maquina de lavar - configurar parametros da maquina e testar ciclos
// validar conhecimentos de laços, condicionais
// implementadas algumas situações e variações para sedimentação de conceitos 

package logica_programacao;

import java.util.Scanner;

public class maquina_lavar_v3 {

	public static void evolucaoCiclo(int tempo) throws InterruptedException {
		// metodo para calculo da barra de progressão por intervalo de 20%
		// carrega o tempo de cada ciclo
		int porcento = 0;
		int time = (tempo * 1000) / 5;
		for (int x = 0; x < 5; x++) {
			System.out.print(porcento + "% - ");
			Thread.sleep(time);
			porcento = porcento + 20;
		}
		System.out.println("100%");
	}

	public static void main(String[] args) throws InterruptedException {

		Scanner teclado = new Scanner(System.in);
		int opcao;
		String modelo = null, nome = null;
		int volts =0, quilos=0, tpesado=0, tnormal=0, tleve=0, tenxague=0, tcentri=0;
		int repeticao = 1;
		int porcento, y;
		String[] maquina = new String[2];

		while (repeticao != 0) {
			System.out.println(" ");
			System.out.println("*************************");
			System.out.println("*   Empresa Xilipindum  *");
			System.out.println("*************************");
			System.out.println("   MENU DE SIMULAÇÃO");
			System.out.println("1) Configurar a maquina de lavar");
			System.out.println("2) Simular a maquina de lavar");
			System.out.println("0) Encerrar programa");
			System.out.println(" ");
			do {
				System.out.println("Digite a opção:");
				opcao = teclado.nextInt();
			} while (opcao < 0 || opcao > 2);

			switch (opcao) {
			case 1:
				quilos = volts = tpesado = tnormal = tleve = tenxague = tcentri = 0;
				System.out.println(" ");
				System.out.println("*******************************");
				System.out.println("*   CONFIGURACAO DA MAQUINA   *");
				System.out.println("* Digite os parâmetros abaixo *");
				System.out.println("*******************************");
				System.out.print("Modelo da maquina (campo livre): ");
				modelo = teclado.next();
				System.out.print("");
				maquina[0] = modelo;
				System.out.print("Nome comercial (campo livre): ");
				nome = teclado.next();
				System.out.print("");
				maquina[1] = nome;
				while (volts != 110 && volts != 220) {
					System.out.print("Voltagem (110 ou 220): ");
					volts = teclado.nextInt();
				}
				while (quilos != 5 && quilos != 7 && quilos != 10 && quilos != 15) {
					System.out.print("Quantos Quilos (5, 7, 10 e 15): ");
					quilos = teclado.nextInt();
				}
				while (tpesado > 60 || tpesado < 1) {
					System.out.print("Tempo do ciclo pesado (1s a 60s): ");
					tpesado = teclado.nextInt();
				}
				while (tnormal > 60 || tnormal < 1) {
					System.out.print("Tempo do ciclo normal (1s a 60s): ");
					tnormal = teclado.nextInt();
				}
				while (tleve > 60 || tleve < 1) {
					System.out.print("Tempo do ciclo leve (1s a 60s): ");
					tleve = teclado.nextInt();
				}
				while (tenxague > 60 || tenxague < 1) {
					System.out.print("Tempo do enxague (1s a 60s): ");
					tenxague = teclado.nextInt();
				}
				while (tcentri > 60 || tcentri < 1) {
					System.out.print("Tempo da centrifugação (1s a 60s): ");
					tcentri = teclado.nextInt();
				}
				System.out.println(" ");
				System.out.println("<< Parametros carregados, simule a maquina ou carregue novos valores >>");
				Thread.sleep(1000);
				break;

			case 2:
				if (volts == 0) {
					System.out.println("Retornando para menu para carregar os dados");
					Thread.sleep(1000);
					break;
				}
				System.out.println(" ");
				System.out.println("**************************");
				System.out.println("*  SIMULAÇÃO DA MAQUINA  *");
				System.out.println("**************************");
				System.out.print("simulando o modelo: ");
				// usando array String para recuperar os valores de nome e modelo
				System.out.println(maquina[0] + " " + maquina[1] + " " + quilos + "Kg " + volts + "v");
				System.out.println("1) Lavação pesada " + tpesado + "s");
				System.out.println("2) Lavação normal " + tnormal + "s");
				System.out.println("3) Lavação leve " + tleve + "s");
				System.out.println("4) Enxague " + tenxague + "s");
				System.out.println("5) Centrifugação " + tcentri + "s");
				System.out.println("Digite por qual ciclo começar");
				int ciclo = teclado.nextInt();

				switch (ciclo) {
				case 1:
					// usando chamada de metodo para gerar a barra
					// variavel repassada é o tempo do ciclo completo
					System.out.print("Lavação pesada: ");
					evolucaoCiclo(tpesado);

				case 2:
					// outra forma de fazer o calculo de 20% menos exata para tempos
					// menores de 5s porém barra é mais dinamica
					System.out.print("Lavação normal: ");
					porcento = 0;
					y = 0;
					while (y < 5) {
						System.out.print(porcento + "%");
						for (int x = 0; x < tnormal * 0.2;) {
							System.out.print("=");
							Thread.sleep(1000);
							x++;
						}
						porcento = porcento + 20;
						y++;
					}
					System.out.println("100%");

				case 3:
					System.out.print("Lavação leve: ");
					evolucaoCiclo(tleve);

				case 4:
					System.out.print("Enxague: ");
					evolucaoCiclo(tenxague);

				case 5:
					System.out.print("Centrifugação: ");
					evolucaoCiclo(tcentri);
					break;

				default:
					System.err.print("Opção invalida, voltando ao menu");
					System.out.println(" ");
					break;
				}
				break;
			case 0:
				System.out.println(" ");
				System.out.println("********************************************");
				System.out.println("Obrigado por escolher as maquinas Xilipindum");
				System.out.println("********************************************");
				repeticao = 0;

			}
		}
	}
}
