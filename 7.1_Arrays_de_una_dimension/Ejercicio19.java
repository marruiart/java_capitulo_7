
/**
 * Este programa es capaz de insertar un número en una posición
 * concreta de un array. En primer lugar, el programa generará un array de 12
 * números enteros aleatorios entre 0 y 200 ambos incluidos. A continuación se
 * debe mostrar el contenido de ese array junto al índice (0 – 11). Seguidamente
 * el programa preguntará por el número que se quiere insertar y por la posición
 * donde será insertado. Los números del array se desplazan a la derecha para
 * dejar sitio al nuevo. El último número (el que se encuentra en la posición
 * 11) siempre se perderá.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio19 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arrayLength = 12;
        int[] originalArray = new int[arrayLength];
        int[] modifiedArray = new int[arrayLength];
        int position = 0;
        int numToInsert = 0;

        for (int i = 0; i < arrayLength; i++) {
            int num = getRandomInt(0, 200);
            originalArray[i] = num;
        }

        System.out.print("\nARRAY INICIAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", originalArray[i]);

        do {
            System.out.printf("\n\nIntroduzca el número que quiere insertar (0 - 200): ");
            numToInsert = s.nextInt();
            System.out.printf("Introduzca la posición donde lo quiere insertar (0 - 11): ");
            position = s.nextInt();
            if (position > 11 || position < 0 || numToInsert < 0 || numToInsert > 200)
                System.out.println("Datos introducidos incorrectos.");
        } while (position > 11 || position < 0 || numToInsert < 0 || numToInsert > 200);
        s.close();

        System.out.print("\nARRAY FINAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf(" %3d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < arrayLength; i++) {
            if (i == position)
                modifiedArray[i] = numToInsert;
            else if (i < position)
                modifiedArray[i] = originalArray[i];
            else
                modifiedArray[i] = originalArray[i - 1];
            System.out.printf(" %3d |", modifiedArray[i]);
        }
    }
}