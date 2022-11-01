
/**
 * Este programa es el juego del tres en raya.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio10 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static int[] getRandomCoordinate(int[][] previousMoves, int move) {
        int[] randomCoordinate = new int[2];
        boolean isAvailable;
        do {
            randomCoordinate[0] = getRandomInt(0, 2);
            randomCoordinate[1] = getRandomInt(0, 2);
            isAvailable = checkAvailability(randomCoordinate, previousMoves, move);
        } while (!isAvailable);
        return randomCoordinate;
    }

    public static boolean checkAvailability(int[] coordinate, int[][] previousMoves, int move) {
        boolean isAvailable = true;
        for (int i = 0; i < move; i++) {
            if (checkEqualArrays(previousMoves[i], coordinate)) {
                isAvailable = false;
                return isAvailable;
            }
        }
        return isAvailable;
    }

    public static boolean checkEqualArrays(int[] array1, int[] array2) {
        boolean arraysAreEqual = false;
        if (array1[0] == array2[0] && array1[1] == array2[1])
            arraysAreEqual = true;
        return arraysAreEqual;
    }

    public static void printBoard(String[][] board) {
        int rows = 3;
        int columns = 3;

        for (int i = -1; i < rows; i++) {
            for (int j = -1; j < columns; j++) {
                if (i == -1) {
                    if (j == -1)
                        System.out.print("   ");
                    else
                        System.out.printf("%s ", (char) (j + 97));
                } else if (j == -1)
                    System.out.printf("%2d ", i + 1);
                else
                    System.out.printf("\033[30m%s\033[97m ", board[i][j] == null ? "#" : board[i][j]);
            }
            System.out.println();
        }
    }

    public static int checkWinner(String[][] board) {
        int winner = 0;
        for (int row = 0; row < 3; row++)
            if (board[row][0] != null && (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2]))) {
                winner = board[row][0].equals("\033[96mO\033[97m") ? 1 : 2;
                return winner;
            }
        for (int col = 0; col < 3; col++)
            if (board[0][col] != null && (board[0][col].equals(board[1][col]) && board[1][col].equals(board[2][col]))) {
                winner = board[0][col].equals("\033[96mO\033[97m") ? 1 : 2;
                return winner;
            }
        if (board[0][0] != null && (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))) {
            winner = board[0][0].equals("\033[96mO\033[97m") ? 1 : 2;
            return winner;
        }
        if (board[0][2] != null && (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]))) {
            winner = board[0][2].equals("\033[96mO\033[97m") ? 1 : 2;
            return winner;
        }
        return winner;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] coordinates = new int[2];
        int[][] previousMoves = new int[9][2];
        String[][] board = new String[3][3];
        int player = 1;
        int move = 0;

        System.out.print("Elija el modo de juego (1-Contra la máquina, 2-Dos jugadores): ");
        int gameMode = s.nextInt();

        printBoard(board);

        do {
            boolean isAvailable = true;
            // Players
            if (player == 1 || (player == 2 && gameMode == 2)) {
                System.out.printf("\nJugador %d - Elija las coordenadas (negativo para salir).\n", player);
                System.out.printf("Columna (a-%s): ", (char) (3 + 96));
                char tmp = s.next().charAt(0);
                coordinates[1] = (int) tmp - 'a';
                if (coordinates[1] == (int) '-' - 'a') {
                    s.close();
                    return;
                }
                System.out.printf("Fila (1-%d): ", 3);
                coordinates[0] = s.nextInt() - 1;
                isAvailable = checkAvailability(coordinates, previousMoves, move);
            } else {
                System.out.println("\nJuega la máquina...");
                coordinates = getRandomCoordinate(previousMoves, move);
            }

            if ((player == 1 || (player == 2 && gameMode == 2))
                    && (!isAvailable || (coordinates[1] < 0 || coordinates[1] > 3 - 1
                            || coordinates[0] < 0 || coordinates[0] > 3 - 1)))
                System.out.println("\nCoordenada incorrecta.");
            else {
                board[coordinates[0]][coordinates[1]] = player == 1 ? "\033[96mO\033[97m" : "\033[31mX\033[97m";
                printBoard(board);

                player = player == 1 ? 2 : 1;
                previousMoves[move][0] = coordinates[0];
                previousMoves[move][1] = coordinates[1];

                move++;

                int winner = checkWinner(board);
                if (winner == 1 || winner == 2) {
                    System.out.printf("\n¡HA GANADO EL JUGADOR %d!", winner);
                    s.close();
                    return;
                } else if (move == 9) {
                    System.out.print("\nHabéis quedado empate");
                    s.close();
                    return;
                }
            }
        } while (coordinates[1] >= 0);
        s.close();
    }
}