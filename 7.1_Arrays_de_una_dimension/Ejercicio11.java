
/**
 * Este programa pide 10 números por teclado y los almacena en
 * un array. A continuación se mostrará el contenido de ese array junto al
 * índice (0 – 9) utilizando para ello una tabla. Seguidamente el programa
 * pasará los primos a las primeras posiciones, desplazando el resto de números
 * (los que no son primos) de tal forma que no se pierda ninguno. Al final se
 * debe mostrar el array resultante.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio11 {

    public static boolean isPrime(int num) {
        boolean primeNum = true;
        if (num <= 1)
            primeNum = false;
        else
            for (int i = 2; i <= num / 2; i++)
                if (num % i == 0)
                    primeNum = false;
        return primeNum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        int[] originalArray = new int[10];
        int[] modifiedArray = new int[10];
        int[] tmpArray = new int[10];
        int position = 0;
        int modifiedPosition = 0;
        int tmpPosition = 0;
        int countPrimes = 0;

        do {
            System.out.printf("%d - Introduzca un número: ", position + 1);
            num = s.nextInt();
            originalArray[position] = num;
            if (isPrime(num)) {
                modifiedArray[modifiedPosition] = num;
                modifiedPosition++;
                countPrimes++;
            } else {
                tmpArray[tmpPosition] = num;
                tmpPosition++;
            }
            position++;
        } while (position < 10);
        s.close();

        System.out.print("\nARRAY INICIAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %10d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %10d |", originalArray[i]);
        System.out.print("\n\nARRAY FINAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %10d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 10; i++) {
            if (i + countPrimes < 10)
                modifiedArray[i + countPrimes] = tmpArray[i];
            System.out.printf(" %10d |", modifiedArray[i]);
        }
    }
}
