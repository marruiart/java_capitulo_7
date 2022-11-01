
/**
 * Este programa es capaz de rotar todos los elementos de una matriz
 * cuadrada una posición en el sentido de las agujas del reloj. La matriz debe
 * tener 12 filas por 12 columnas y debe contener números generados al azar
 * entre 0 y 100. Se debe mostrar tanto la matriz original como la matriz
 * resultado, ambas con los números convenientemente alineados.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio9 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void printMatrix(int[][] matrix, final int ROWS, final int COLUMNS, boolean rotated) {
        int greenAdjust = 0;
        int yellowAdjust = 0;
        int blueAdjust = -1;
        int redAdjust = -1;
        if (rotated) {
            greenAdjust = -1;
            yellowAdjust = +1;
            blueAdjust = -2;
            redAdjust = 0;
        }

        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLUMNS; j++) {
                if ((i == j + greenAdjust) && (i < ROWS / 2))
                    System.out.printf("\033[32m %3s \033[97m|", matrix[i][j]); // green
                else if ((i == j + yellowAdjust) && (i >= ROWS / 2))
                    System.out.printf("\033[33m %3s \033[97m|", matrix[i][j]); // yellow
                else if ((i == COLUMNS - j + blueAdjust) && (i >= ROWS / 2 + greenAdjust))
                    System.out.printf("\033[34m %3s \033[97m|", matrix[i][j]); // blue
                else if ((i == COLUMNS - j + redAdjust) && (i <= ROWS / 2))
                    System.out.printf("\033[31m %3s \033[97m|", matrix[i][j]); // red
                else
                    System.out.printf(" %3s |", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void rotateMatrix(int[][] rotatedMatrix, int[][] matrix, final int ROWS, final int COLUMNS) {
        int yellowAdjust = ROWS / 2;
        int greenAdjust = 0;

        for (int i = 0; i <= ROWS; i++) {
            for (int j = 0; j <= COLUMNS; j++) {
                if (i > ROWS / 2 && j >= yellowAdjust && j < COLUMNS - yellowAdjust)
                    rotatedMatrix[i][j] = matrix[i][j + 1]; // yellow
                else if (i <= ROWS / 2 && j > greenAdjust && j <= COLUMNS - greenAdjust)
                    rotatedMatrix[i][j] = matrix[i][j - 1]; // green
                else if (j <= COLUMNS / 2)
                    rotatedMatrix[i][j] = matrix[i + 1][j]; // blue
                else
                    rotatedMatrix[i][j] = matrix[i - 1][j]; // red
            }
            if (i > ROWS / 2)
                yellowAdjust--;
            else
                greenAdjust++;
        }
    }

    public static void main(String[] args) {
        final int ROWS = 12;
        final int COLUMNS = 12;
        final int MAX = 100;
        final int MIN = 0;

        int[][] matrix = new int[ROWS][COLUMNS];
        int[][] rotatedMatrix = new int[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLUMNS; j++)
                matrix[i][j] = getRandomInt(MIN, MAX);

        System.out.println("ARRAY ORIGINAL");
        printMatrix(matrix, ROWS, COLUMNS, false);

        rotateMatrix(rotatedMatrix, matrix, ROWS - 1, COLUMNS - 1);

        System.out.println("\nARRAY ROTADO");
        printMatrix(rotatedMatrix, ROWS, COLUMNS, true);

    }
}