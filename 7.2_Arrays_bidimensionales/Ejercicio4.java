/**
 * Este programa rellena 20 números enteros aleatorios. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha. Cuando
 * aparecen las sumas pariclaes y la suma total aparecen con un pequeño retardo.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio4 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) - 1));
        return randomInt;
    }

    public static void main(String[] args)
            throws InterruptedException {
        int rows = 4;
        int columns = 5;
        int[][] num = new int[rows][columns];
        int[] sumRows = { 0, 0, 0, 0 };
        int[] sumColumns = { 0, 0, 0, 0, 0 };
        int total = 0;

        int row = 0;
        int column = 0;
        for (int i = 1; i <= 20; i++) {
            num[row][column] = getRandomInt(100, 999);
            column++;
            if (i % 5 == 0) {
                row++;
                column = 0;
            }
        }

        System.out.println();
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i != rows && j != columns) {
                    sumRows[i] += num[i][j];
                    sumColumns[j] += num[i][j];
                    total += num[i][j];
                    System.out.printf("%7d \033[97m|", num[i][j]);
                } else if (j == columns && i != rows) {
                    Thread.sleep(500);
                    System.out.printf("\033[96m%7d \033[97m|", sumRows[i]);
                } else if (i == rows && j != columns) {
                    Thread.sleep(500);
                    System.out.printf("\033[93m%7d \033[97m|", sumColumns[j]);
                } else {
                    Thread.sleep(1000);
                    System.out.printf("\033[31m%7d \033[97m|", total);
                }
            }
            System.out.println();
        }
    }
}