
/**
 * Este programa pide 10 números por teclado y los almacena en un array
 * A continuación se mostrará el contenido de ese array junto al índice
 * (0 – 9). Seguidamente el programa pedirá dos posiciones a las que
 * llamaremos “inicial” y “final”. Se comprueba que inicial es menor que final y
 * que ambos números están entre 0 y 9. El programa coloca el número de la
 * posición inicial en la posición final, rotando el resto de números para que
 * no se pierda ninguno. Al final se muestra el array resultante.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num;
        int[] originalArray = new int[10];
        int[] rotatedArray = new int[10];
        int position = 0;
        int initialPosition = 0;
        int finalPosition = 0;

        do {
            System.out.printf("%d - Introduzca un número: ", position + 1);
            num = s.nextInt();
            originalArray[position] = num;
            position++;
        } while (position < 10);

        System.out.print("\nARRAY INICIAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %10d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %10d |", originalArray[i]);

        do {
            System.out.printf("\n\nIntroduzca la posición inicial del array rotado (0-9): ");
            initialPosition = s.nextInt();
            System.out.printf("Introduzca la posición final del array rotado (0-9): ");
            finalPosition = s.nextInt();
            if (initialPosition > finalPosition || !(initialPosition >= 0 && initialPosition <= 9)
                    || !(finalPosition >= 0 && finalPosition <= 9))
                System.out.println("Posiciones incorrectas.");
        } while (initialPosition > finalPosition || !(initialPosition >= 0 && initialPosition <= 9)
                || !(finalPosition >= 0 && finalPosition <= 9));
        s.close();

        System.out.print("\nARRAY FINAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 10; i++) {
            System.out.printf(" %10d |", i);
            if (i == 0)
                rotatedArray[0] = originalArray[9];
            else if (i == finalPosition)
                rotatedArray[i] = originalArray[initialPosition];
            else if (i > initialPosition && i < finalPosition)
                rotatedArray[i] = originalArray[i];
            else
                rotatedArray[i] = originalArray[i - 1];
        }
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 10; i++) {
            System.out.printf(" %10d |", rotatedArray[i]);
        }
    }
}
