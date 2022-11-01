/**
 * Este programa muestra por pantalla un array de 10 filas por 10
 * columnas relleno con números aleatorios entre 200 y 300. A continuación, el
 * programa debe mostrar los números de la diagonal que va desde la esquina
 * superior izquierda a la esquina inferior derecha, así como el máximo, el
 * mínimo y la media de los números que hay en esa diagonal.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio11 {
    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void main(String[] args) {
        final int ROWS = 10;
        final int COLUMNS = 10;
        final int MAX = 300;
        final int MIN = 200;

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
                if ((i == j) && ((i < ROWS / 2) || (i >= ROWS / 2))) {
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