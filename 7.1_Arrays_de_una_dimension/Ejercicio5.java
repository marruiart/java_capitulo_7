
/**
 * Este programa pide 10 números por teclado y luego muestra los
 * números introducidos junto con las palabras “máximo” y “mínimo” al lado del
 * máximo y del mínimo respectivamente.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        int[] numArray = new int[10];
        int position = 0;
        int min = (int) (Math.pow(2, 32) - 1);
        int max = (int) (Math.pow(2, 32)) * (-1) - 1;

        do {
            System.out.printf("%d - Introduzca un número: ", position);
            num = s.nextInt();
            numArray[position] = num;
            if (num < min)
                min = num;
            else if (num > max)
                max = num;
            position++;
        } while (position <= 9);
        s.close();

        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s ", numArray[i]);
            if (numArray[i] == max)
                System.out.println("(máximo)");
            else if (numArray[i] == min)
                System.out.println("(mínimo)");
            else
                System.out.println();
        }
    }
}
