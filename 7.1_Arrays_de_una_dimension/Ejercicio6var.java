
/**
 * Este programa lee 15 números por teclado y los almacena en un array. Rota los
 * elementos de ese array, es decir, el elemento de la posición 0 pasa a la
 * posición 1, el de la 1 a la 2, etc. El número que se encuentra en la última
 * posición pasa a la posición 0. Finalmente, muestra el contenido del array.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio6var {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = 15;
        int[] n = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.printf("%d - Introduzca un número: ", i + 1);
            n[i] = s.nextInt();
        }

        System.out.println("Array original");
        System.out.print("| Índice  |");
        for (int i = 0; i < length; i++)
            System.out.printf("%4d |", i);
        System.out.print("\n| Valor   |");
        for (int i = 0; i < length; i++)
            System.out.printf("%4d |", n[i]);

        /* Rotation */
        int last = n[length - 1];
        for (int i = length - 1; i >= 1; i--)
            n[i] = n[i - 1];
        n[0] = last;

        s.close();

        System.out.println("\n\nArray rotado");
        System.out.print("| Índice  |");
        for (int i = 0; i < length; i++)
            System.out.printf("%4d |", i);
        System.out.print("\n| Valor   |");
        for (int i = 0; i < length; i++)
            System.out.printf("%4d |", n[i]);

    }
}
