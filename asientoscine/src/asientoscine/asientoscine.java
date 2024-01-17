package asientoscine;

import java.util.Scanner;

public class asientoscine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char[][] asientos = new char[5][5];
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				asientos[i][j] = 'X';
			}
		}

		while (true) {
			mostrarAsientos(asientos);

			System.out.print("Ingrese el número de fila (1-" + asientos.length + "): ");
			int fila = scanner.nextInt();

			System.out.print("Ingrese el número de columna (1-" + asientos[0].length + "): ");
			int columna = scanner.nextInt();

			if (verificarAsiento(asientos, fila, columna)) {
				asientos[fila - 1][columna - 1] = 'O';
				System.out.println("¡Reserva con exito!");
			} else {
				System.out.println("¡El asiento ya no no es válido! Intente nuevamente.");
			}

			System.out.print("¿Desea hacer otra reserva? (S/N): ");
			char respuesta = scanner.next().charAt(0);

			if (respuesta != 'S' && respuesta != 's') {
				System.out.println("¡Gracias por usar el sistema de reserva de asientos!");
				break;
			}
		}

		scanner.close();
	}

	private static void mostrarAsientos(char[][] asientos) {
		System.out.println("Estado de los asientos:");
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				System.out.print(asientos[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean verificarAsiento(char[][] asientos, int fila, int columna) {
		if (fila >= 1 && fila <= asientos.length && columna >= 1 && columna <= asientos[0].length) {
			return asientos[fila - 1][columna - 1] == 'X';
		}
		return false;
	}

}
