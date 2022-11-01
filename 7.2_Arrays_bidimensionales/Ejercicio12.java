/**
 * Este programa muestra por pantalla un array de 9 filas por 9
 * columnas relleno con números aleatorios entre 500 y 900. A continuación, el
 * programa debe mostrar los números de la diagonal que va desde la esquina
 * inferior izquierda a la esquina superior derecha, así como el máximo, el
 * mínimo y la media de los números que hay en esa diagonal.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio12 {
    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void main(String[] args) {
        final int ROWS = 9;
        final int COLUMNS = 9;
        final int MAX = 900;
        final int MIN = 500;

        int[][] num = new int[ROWS][COLUMNS + 3];
        int max = MIN;
        int min = MAX;
        int sumDiagonal = 0;
        int[] numsDiagonal = new int[COLUMNS];

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

        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLUMNS; j++) {
                if ((i == COLUMNS - 1 - j) && ((i < ROWS / 2) || (i >= ROWS / 2))) {
                    System.out.printf("\033[31m %3s \033[97m|", num[i][j]);
                    sumDiagonal += num[i][j];
                    numsDiagonal[j] = num[i][j];
                    if (max < num[i][j])
                        max = num[i][j];
                    if (min > num[i][j])
                        min = num[i][j];
                } else
                    System.out.printf(" %3s |", num[i][j]);
            }
            System.out.println();
        }

        System.out.printf("\nLos %d números incluidos en la diagonal son: \n", COLUMNS);
        for (int i = 0; i < COLUMNS; i++)
            System.out.printf("%d  ", numsDiagonal[i]);
        System.out.printf("\nEl máximo es %d", max);
        System.out.printf("\nEl mínimo es %d", min);
        System.out.printf("\nLa media de los números de la diagonal es %.2f", (float) sumDiagonal / COLUMNS);
    }
}