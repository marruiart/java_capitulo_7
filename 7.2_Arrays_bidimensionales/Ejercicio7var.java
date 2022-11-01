
/**
 * Este programa es una variación del buscaminas para dos jugadores. 
 * Implementa el juego “Flags” de tal forma que se indica cuántas 
 * banderas hay a una casilla de distancia. Gana el jugador que encuentre
 * más banderas. 
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio7var {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static int[] getRandomCoordinate(int max) {
        int[] randomCoordinate = new int[2];
        randomCoordinate[0] = getRandomInt(0, max);
        randomCoordinate[1] = getRandomInt(0, max);
        return randomCoordinate;
    }

    public static boolean checkEqualArrays(int[] array1, int[] array2) {
        boolean arraysAreEqual = false;
        if (array1[0] == array2[0] && array1[1] == array2[1])
            arraysAreEqual = true;
        return arraysAreEqual;
    }

    public static int countMines(String[][] map, int[] position, int max) {
        int mines = 0;
        for (int i = -1; i <= 1; i++)
            if (position[0] + i >= 0 && position[0] + i < max)
                for (int j = -1; j <= 1; j++)
                    if (position[1] + j >= 0 && position[1] + j < max)
                        if (map[position[0] + i][position[1] + j] == "\033[33m*\033[97m")
                            mines++;
        return mines;
    }

    public static void fillTreasureMap(int mapSize, String[][] map, int minesNumber) {
        int[][] mines = new int[minesNumber][2];
        boolean isRepeated;

        for (int mine = 0; mine < minesNumber; mine++) {
            do {
                mines[mine] = getRandomCoordinate(mapSize - 1);
                isRepeated = false;
                for (int preMine = 0; preMine < mine; preMine++) {
                    isRepeated = checkEqualArrays(mines[mine], mines[preMine]) ? true : false;
                    if (isRepeated)
                        break;
                }
            } while (isRepeated);
            map[mines[mine][0]][mines[mine][1]] = "\033[33m*\033[97m";
        }
        for (int i = 0; i < mapSize; i++)
            for (int j = 0; j < mapSize; j++)
                if (map[i][j] == null) {
                    int[] position = { i, j };
                    int minesAround = countMines(map, position, mapSize);
                    if (minesAround == 0)
                        map[i][j] = "\033[34m~\033[97m";
                    else
                        map[i][j] = "\033[96m" + String.valueOf(minesAround) + "\033[97m";
                }
    }

    public static void printMap(String[][] map, int mapSize) {
        int rows = mapSize;
        int columns = mapSize;

        for (int row = -1; row < rows; row++) {
            for (int column = -1; column < columns; column++) {
                if (row == -1) {
                    if (column == -1)
                        System.out.print("   ");
                    else
                        System.out.printf("%s ", (char) (column + 97));
                } else if (column == -1)
                    System.out.printf("%2d ", row + 1);
                else
                    System.out.printf("\033[30m%s\033[97m ", map[row][column] == null ? "#" : map[row][column]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Elija el tamaño del tablero (máximo 26): ");
        int mapSize = s.nextInt();
        int[] coordinates = new int[2];
        String[][] treasureMap = new String[mapSize][mapSize];
        String[][] playerMap = new String[mapSize][mapSize];
        int player = 1;
        int[] flags = { 0, 0 };
        int minesNumber = mapSize * 2;

        fillTreasureMap(mapSize, treasureMap, minesNumber);
        printMap(playerMap, mapSize);

        do {
            System.out.printf("Minas restantes: %d\n", minesNumber);
            System.out.printf("Puntuación: Jugador 1 - %d  |  Jugador 2 - %d\n", flags[0], flags[1]);

            System.out.printf("\nJugador %d - Elija las coordenadas (negativo para salir). \n", player);
            System.out.printf("Columna (a-%s): ", (char) (mapSize + 96));
            char tmp = s.next().charAt(0);
            coordinates[1] = (int) tmp - 'a';
            if (coordinates[1] == (int) '-' - 'a') {
                s.close();
                return;
            }
            System.out.printf("Fila (1-%d): ", mapSize);
            coordinates[0] = s.nextInt() - 1;

            if (coordinates[1] < 0 || coordinates[1] > mapSize - 1
                    || coordinates[0] < 0 || coordinates[0] > mapSize - 1)
                System.out.println("\nCoordenada incorrecta.");
            if (minesNumber == 1) {
                int winner = flags[0] > flags[1] ? 1 : 2;
                System.out.printf("FIN DEL JUEGO - Ha ganado el jugador %d", winner);
                s.close();
                return;
            } else {
                playerMap[coordinates[0]][coordinates[1]] = treasureMap[coordinates[0]][coordinates[1]];
                printMap(playerMap, mapSize);
                if (playerMap[coordinates[0]][coordinates[1]] == "\033[33m*\033[97m") {
                    playerMap[coordinates[0]][coordinates[1]] = player == 1 ? "\033[31m*\033[97m" : "\033[32m*\033[97m";
                    flags[player - 1]++;
                    minesNumber--;
                } else {
                    player = player == 1 ? 2 : 1;
                }
            }
        } while (coordinates[1] >= 0);
        s.close();
    }
}