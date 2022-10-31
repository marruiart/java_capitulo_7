/**
 * Este programa rellena un array de 6 filas por 10 columnas con
 * números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A
 * continuación, el programa deberá dar la posición tanto del máximo como del
 * mínimo.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio5 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) - 1));
        return randomInt;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 10;
        int[][] num = new int[rows][columns];
        int max = 0;
        int min = 1000;
        int[] maxPosition = new int[2];
        int[] minPosition = new int[2];

        int row = 0;
        int column = 0;
        for (int i = 1; i <= 60; i++) {
            num[row][column] = getRandomInt(0, 1000);
            if (num[row][column] > max) {
                max = num[row][column];
                maxPosition[0] = row;
                maxPosition[1] = column;
            }
            if (num[row][column] < min) {
                min = num[row][column];
                minPosition[0] = row;
                minPosition[1] = column;
            }
            column++;
            if (i % 10 == 0) {
                row++;
                column = 0;
            }
        }

        System.out.printf(
                "El número máximo está en la fila %d y columna %d\nEl número mínimo está en la fila %d y la columna %d\n\n",
                maxPosition[0], maxPosition[1], minPosition[0], minPosition[1]);
        for (int i = -1; i < rows; i++) {
            for (int j = -1; j < columns; j++) {
                if (i == -1) {
                    if (j == -1)
                        System.out.printf("Array num |");
                    else
                        System.out.printf(" Columna %d |", j);
                } else if (j == -1)
                    System.out.printf("  Fila %d  |", i);
                else if (i == maxPosition[0] && j == maxPosition[1])
                    System.out.printf("\033[31m%7d    \033[97m|", num[i][j]);
                else if (i == minPosition[0] && j == minPosition[1])
                    System.out.printf("\033[96m%7d    \033[97m|", num[i][j]);
                else
                    System.out.printf("%7d    |", num[i][j]);
            }
            System.out.println();
        }
    }
}