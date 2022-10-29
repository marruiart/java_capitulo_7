
/**
 * Este programa pide 8 números enteros y luego muestra esos números junto con
 * la palabra “par” o “impar” según proceda.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[8];
        int num;
        int count = 0;

        do {
            System.out.printf("nº %d - Introduzca un número entero: ", count + 1);
            num = s.nextInt();
            nums[count] = num;
            count++;
        } while (count < 8);
        s.close();

        System.out.println();
        for (int i = 0; i < 8; i++) {
            if (nums[i] % 2 == 0)
                System.out.printf("%d par\n", nums[i]);
            else
                System.out.printf("%d impar\n", nums[i]);
        }
    }
}