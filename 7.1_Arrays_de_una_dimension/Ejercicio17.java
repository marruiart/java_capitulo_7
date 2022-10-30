
/**
 * Este programa muestra por pantalla un array de 10 números enteros
 * generados al azar entre 0 y 100. A continuación, el programa debe pedir un
 * número al usuario. Se debe comprobar que el número introducido por teclado
 * se encuentra dentro del array, en caso contrario se mostrará un mensaje por
 * pantalla y se volverá a pedir un número; así hasta que el usuario introduzca
 * uno correctamente. A continuación, el programa rotará el array hacia la
 * derecha las veces que haga falta hasta que el número introducido quede
 * situado en la posición 0 del array. Por último, se mostrará el array rotado
 * por pantalla.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio17 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.printf("%d ", array[i]);
    }

    public static boolean isNotInArray(int num, int[] originalArray, int[] rotatedArray) {
        boolean numberInArray = false;
        int numPosition = -1;

        for (int i = 0; i < originalArray.length; i++)
            if (originalArray[i] == num) {
                numberInArray = true;
                numPosition = i;
            }
        if (numberInArray)
            rotateArray(numPosition, originalArray, rotatedArray);
        return numberInArray;
    }

    public static void rotateArray(int numPosition, int[] originalArray, int[] rotatedArray) {
        int originalArrayLength = originalArray.length;
        for (int i = 0; i < originalArrayLength; i++) {
            if (i >= numPosition)
                rotatedArray[i - numPosition] = originalArray[i];
            else
                rotatedArray[i + (originalArrayLength - numPosition)] = originalArray[i];
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] originalArray = new int[10];
        int[] rotatedArray = new int[10];

        for (int i = 0; i < 10; i++)
            originalArray[i] = getRandomInt(0, 100);
        printArray(originalArray);

        int num;
        boolean numIsInArray;
        do {
            System.out.print("\n\nIntroduzca un número entre 0 y 100: ");
            num = s.nextInt();
            numIsInArray = isNotInArray(num, originalArray, rotatedArray);
            if (!numIsInArray)
                System.out.print("Lo siento, ese número no se encuentra en el array.");
        } while (!numIsInArray);
        s.close();

        System.out.println();
        printArray(rotatedArray);
    }
}