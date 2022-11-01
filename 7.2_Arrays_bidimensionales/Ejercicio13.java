
/**
 * Este programa calcula la estatura media, mínima y máxima en
 * centímetros de personas de diferentes países. El array que contiene los
 * nombres de los paises es el siguiente: pais = {"España", "Rusia", "Japón",
 * "Australia"}. Los datos sobre las estaturas se deben simular mediante un
 * array de 4 filas por 10 columnas con números aleatorios generados al azar
 * entre 140 y 210. Los decimales de la media se pueden despreciar. Los nombres
 * de los países se deben mostrar utilizando el array de países (no se pueden
 * escribir directamente).
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio13 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void main(String[] args) {
        final int ROWS = 4;
        final int COLUMNS = 10;
        final int MAX = 210;
        final int MIN = 140;

        String pais[] = { "España", "Rusia", "Japón", "Australia" };
        int[][] num = new int[ROWS][COLUMNS + 3];
        int[] max = { MIN, MIN, MIN, MIN };
        int[] min = { MAX, MAX, MAX, MAX };
        int[] sumRows = { 0, 0, 0, 0 };

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
        for (int i = -1; i < ROWS; i++) {
            for (int j = -1; j < COLUMNS + 3; j++) {
                if (i == -1) {
                    if (j == -1)
                        System.out.printf("%10s   ", " ");
                    else if (j < 10)
                        System.out.printf(" %3s  ", " ");
                    else
                        switch (j) {
                            case COLUMNS:
                                System.out.printf("\033[91m %3s \033[97m|", "MED");
                                break;
                            case COLUMNS + 1:
                                System.out.printf("\033[91m %3s \033[97m|", "MIN");
                                break;
                            default:
                                System.out.printf("\033[91m %3s \033[97m", "MAX");
                                break;
                        }
                } else if (j == -1)
                    System.out.printf("%10s:  ", pais[i]);
                else if (j < COLUMNS) {
                    sumRows[i] += num[i][j];
                    if (num[i][j] > max[i])
                        max[i] = num[i][j];
                    if (num[i][j] < min[i])
                        min[i] = num[i][j];
                    System.out.printf(" %3d |", num[i][j]);
                } else
                    switch (j) {
                        case COLUMNS:
                            System.out.printf("\033[31m %3d \033[97m|", sumRows[i] / COLUMNS);
                            break;
                        case COLUMNS + 1:
                            System.out.printf("\033[31m %3d \033[97m|", min[i]);
                            break;
                        default:
                            System.out.printf("\033[31m %3d \033[97m|", max[i]);
                            break;
                    }
            }
            System.out.println();
        }
    }
}