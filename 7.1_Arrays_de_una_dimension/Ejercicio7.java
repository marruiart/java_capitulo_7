
/**
 * Este programa genera 100 números aleatorios del 0 al 20 y los muestra por
 * pantalla separados por espacios. El programa pedirá entonces por
 * teclado dos valores y a continuación cambiará todas las ocurrencias del
 * primer valor por el segundo en la lista generada anteriormente. Los números
 * que se han cambiado deben aparecer entrecomillados.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio7 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return (randomInt);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] randomNums = new int[100];
        for (int i = 0; i < 100; i++) {
            randomNums[i] = getRandomInt(0, 20);
            System.out.printf("%d ", randomNums[i]);
        }

        System.out.print("\n\nIntroduzca un número del 0 al 20: ");
        int searchedNum = s.nextInt();
        System.out.print("Introduzca el número del 0 al 20 por el que quieres sustituirlo: ");
        int replaceNum = s.nextInt();
        s.close();

        System.out.println();
        for (int i = 0; i < 100; i++) {
            if (randomNums[i] == searchedNum)
                System.out.printf("\"%d\" ", replaceNum);
            else
                System.out.printf("%d ", randomNums[i]);
        }
    }
}