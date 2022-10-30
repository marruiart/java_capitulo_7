
/**
 * Este programa genera 10 números enteros aleatorios entre 0 y 200
 * ambos incluidos y los almacena en un array. A continuación,
 * muestra el contenido de ese array junto al índice (0 – 9). Seguidamente
 * el programa debe colocar de forma alterna y en orden los menores o iguales de
 * 100 y los mayores de 100: primero menor, luego mayor, luego menor, luego
 * mayor… Cuando se acaben los menores o los mayores, se completará con los
 * números que queden.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio18 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void main(String[] args) {
        int arrayLength = 10;
        int[] originalArray = new int[arrayLength];
        int[] orderedArray = new int[arrayLength];
        int[] above100Array = new int[arrayLength];
        int[] belowOrEqual100Array = new int[arrayLength];
        int iBelow = 0;
        int iAbove = 0;

        for (int i = 0; i < arrayLength; i++) {
            int num = getRandomInt(0, 200);
            originalArray[i] = num;
            if (num <= 100) {
                belowOrEqual100Array[iBelow] = num;
                iBelow++;
            } else {
                above100Array[iAbove] = num;
                iAbove++;
            }
        }

        int aboveLength = iAbove;
        int belowLength = iBelow;
        iBelow = 0;
        iAbove = 0;

        System.out.print("\nARRAY INICIAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", originalArray[i]);
        System.out.print("\n\nARRAY FINAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < arrayLength; i++) {
            if (iBelow >= belowLength) {
                orderedArray[i] = above100Array[iAbove];
                iAbove++;
            } else if (iAbove >= aboveLength) {
                orderedArray[i] = belowOrEqual100Array[iBelow];
                iBelow++;
            } else if (i % 2 == 0) {
                orderedArray[i] = belowOrEqual100Array[iBelow];
                iBelow++;
            } else {
                orderedArray[i] = above100Array[iAbove];
                iAbove++;
            }
            System.out.printf(" %3d |", orderedArray[i]);
        }
    }
}