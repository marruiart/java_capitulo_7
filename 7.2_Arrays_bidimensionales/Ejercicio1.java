
/**
 * Este programa define un array de números enteros de 3 filas por 6 columnas
 * con nombre num y asigna los valores según la siguiente tabla. Muestra el
 * contenido de todos los elementos del array dispuestos en forma de tabla.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio1 {
    public static void main(String[] args) {
        final int ROWS = 3;
        final int COLUMNS = 6;

        int[][] num = new int[ROWS][COLUMNS];
        num[0][0] = 0;
        num[0][1] = 30;
        num[0][2] = 2;
        num[0][5] = 5;
        num[1][0] = 75;
        num[1][4] = 0;
        num[2][2] = -2;
        num[2][3] = 9;
        num[2][5] = 11;

        for (int i = -1; i < ROWS; i++) {
            for (int j = -1; j < COLUMNS; j++) {
                if (i == -1) {
                    if (j == -1)
                        System.out.printf("Array num |");
                    else
                        System.out.printf(" Columna %d |", j);
                } else if (j == -1)
                    System.out.printf("  Fila %d  |", i);
                else
                    System.out.printf("%7d    |", num[i][j]);
            }
            System.out.println();
        }
    }
}