
/**
 * Este programa pide 20 números enteros. Estos números se deben
 * introducir en un array de 4 filas por 5 columnas. El programa mostrará las
 * sumas parciales de filas y columnas igual que si de una hoja de cálculo se
 * tratara. La suma total debe aparecer en la esquina inferior derecha.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = 4;
        int columns = 5;
        int[][] num = new int[rows][columns];
        int[] sumRows = { 0, 0, 0, 0 };
        int[] sumColumns = { 0, 0, 0, 0, 0 };
        int total = 0;

        int row = 0;
        int column = 0;
        for (int i = 1; i <= 20; i++) {
            System.out.printf("nº %d - Introduzca un número: ", i);
            num[row][column] = s.nextInt();
            column++;
            if (i % 5 == 0) {
                row++;
                column = 0;
            }
        }
        s.close();

        System.out.println();
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i != rows && j != columns) {
                    sumRows[i] += num[i][j];
                    sumColumns[j] += num[i][j];
                    total += num[i][j];
                    System.out.printf("%7d \033[97m|", num[i][j]);
                } else if (j == columns && i != rows)
                    System.out.printf("\033[96m%7d \033[97m|", sumRows[i]);
                else if (i == rows && j != columns)
                    System.out.printf("\033[93m%7d \033[97m|", sumColumns[j]);
                else
                    System.out.printf("\033[31m%7d \033[97m|", total);
            }
            System.out.println();
        }
    }
}