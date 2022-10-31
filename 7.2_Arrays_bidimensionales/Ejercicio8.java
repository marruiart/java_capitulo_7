
/**
 * Este programa, dada una posición en un tablero de ajedrez, nos dice a qué
 * casillas podría saltar un alfil que se encuentra en esa posición. El tablero
 * cuenta con 64 casillas. Las columnas se indican con las letras de la “a” a la
 * “h” y las filas se indican del 1 al 8.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio8 {

    public static void getBishopMoves(int[] bishopPosition, int[][] bishopMoves) {
        for (int row = 8; row > 0; row--) {
            if (bishopPosition[0] != row) {
                // find both column possitions in each row
                bishopMoves[row - 1][0] = bishopPosition[1] + (Math.abs(bishopPosition[0] - row));
                bishopMoves[row - 1][1] = bishopPosition[1] - (Math.abs(bishopPosition[0] - row));
            } else {
                // bishop possitions are included as -1
                bishopMoves[row - 1][0] = -1;
                bishopMoves[row - 1][1] = -1;
            }
        }
    }

    public static void printChessboard(int[] bishopPosition) {
        int rows = 8;
        int columns = 8;
        String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };
        int[][] bishopMoves = new int[8][2];
        getBishopMoves(bishopPosition, bishopMoves);

        for (int row = rows + 1; row >= 0; row--) {
            for (int column = -1; column <= columns; column++) {
                if (row == 0 || row == rows + 1) {
                    if (column == -1 || column == columns)
                        // print corners
                        System.out.print("  ");
                    else
                        // print letters on top and bottom of the chessboard
                        System.out.printf("%s ", letters[column]);
                } else if (column == -1 || column == columns)
                    // print numbers on left and right of the chessboard
                    System.out.printf("%d ", row);
                else if (row == bishopPosition[0] && column == bishopPosition[1])
                    // print bishop red
                    System.out.printf("\033[31m%s\033[97m ", "&");
                else if (column == bishopMoves[row - 1][0] || column == bishopMoves[row - 1][1])
                    // print bishop moves cian
                    System.out.printf("\033[96m%s\033[97m ", "x");
                else {
                    // print chessboard black and white
                    if (row % 2 == 0 && column % 2 == 0 || row % 2 != 0 && column % 2 != 0)
                        System.out.printf("%s ", "#");
                    else
                        System.out.printf("\033[30m%s\033[97m ", "#");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] bishopPosition = new int[2];
        System.out.println("Introduzca la casilla donde se encuentra el alfil. ");
        do {
            System.out.print("Letra de la casilla (a-h): ");
            char tmp = s.next().charAt(0);
            bishopPosition[1] = (int) tmp - 'a';
            System.out.print("Número de la casilla (1-8): ");
            bishopPosition[0] = s.nextInt();
            if (bishopPosition[1] < 0 || bishopPosition[1] > 7 || bishopPosition[0] < 1 || bishopPosition[0] > 8)
                System.out.println("\nPosición incorrecta.");
        } while (bishopPosition[1] < 0 || bishopPosition[1] > 7 || bishopPosition[0] < 1 || bishopPosition[0] > 8);
        s.close();
        printChessboard(bishopPosition);
        System.out.println();
    }
}