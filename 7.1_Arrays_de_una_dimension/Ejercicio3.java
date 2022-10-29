
/**
 * Este programa lee 10 números por teclado y luego los muestra en orden
 * inverso, es decir, el primero que se introduce es el último en mostrarse y
 * viceversa.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        int[] numArray = new int[10];
        int position = 0;

        do {
            System.out.printf("%d - Introduzca un número: ", position);
            num = s.nextInt();
            numArray[position] = num;
            position++;
        } while (position <= 9);
        s.close();

        for (int i = 9; i >= 0; i--)
            System.out.printf("%s ", numArray[i]);
    }
}
