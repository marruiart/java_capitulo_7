/**
 * Este programa rellena 20 números enteros aleatorios. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio3 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) - 1));
        return randomInt;
    }

    public static void main(String[] args) {
        final int ROWS = 4;
        final int COLUMNS = 5;
        final int MAX = 999;
        final int MIN = 100;

        int[][] num = new int[ROWS][COLUMNS];
        int[] sumRows = { 0, 0, 0, 0 };
        int[] sumColumns = { 0, 0, 0, 0, 0 };
        int total = 0;

        int row = 0;
        int column = 0;
        for (int i = 1; i <= ROWS * COLUMNS; i++) {
            num[row][column] = getRandomInt(MIN, MAX);
            column++;
            if (i % COLUMNS == 0) {
                row++;
                column = 0;
            }
        }

        System.out.println();
        for (int i = 0; i <= ROWS; i++) {
            for (int j = 0; j <= COLUMNS; j++) {
                if (i != ROWS && j != COLUMNS) {
                    sumRows[i] += num[i][j];
                    sumColumns[j] += num[i][j];
                    total += num[i][j];
                    System.out.printf("%7d \033[97m|", num[i][j]);
                } else if (j == COLUMNS && i != ROWS)
                    System.out.printf("\033[96m%7d \033[97m|", sumRows[i]);
                else if (i == ROWS && j != COLUMNS)
                    System.out.printf("\033[93m%7d \033[97m|", sumColumns[j]);
                else
                    System.out.printf("\033[31m%7d \033[97m|", total);
            }
            System.out.println();
        }
    }
}