
/**
 * Este programa lee 15 números por teclado y los almacena en un array. Rota los
 * elementos de ese array, es decir, el elemento de la posición 0 pasa a la
 * posición 1, el de la 1 a la 2, etc. El número que se encuentra en la última
 * posición pasa a la posición 0. Finalmente, muestra el contenido del array.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        int[] originalArray = new int[15];
        int[] rotatedArray = new int[15];
        int position = 0;

        do {
            System.out.printf("%d - Introduzca un número: ", position);
            num = s.nextInt();
            originalArray[position] = num;
            if (position == 14)
                rotatedArray[0] = num;
            else
                rotatedArray[position + 1] = num;
            position++;
        } while (position <= 14);
        s.close();

        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("| Original |");
        for (int i = 0; i < 15; i++)
            System.out.printf("%10d |", originalArray[i]);
        System.out.print("\n| Rotado   |");
        for (int i = 0; i < 15; i++)
            System.out.printf("%10d |", rotatedArray[i]);
        System.out.println(
                "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
