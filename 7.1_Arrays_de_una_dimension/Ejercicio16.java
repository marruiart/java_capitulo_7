
/**
 * Este programa rellena un array de 20 elementos con números enteros
 * aleatorios comprendidos entre 0 y 400 (ambos incluidos). A continuación el
 * programa mostrará el array y preguntará si el usuario quiere resaltar los
 * múltiplos de 5 o los múltiplos de 7. Seguidamente se volverá a mostrar el
 * array escribiendo los números que se quieren resaltar entre corchetes.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio16 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void printArray(int[] array, int highlight) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % highlight == 0 && highlight != 1)
                System.out.printf("[%d] ", array[i]);
            else
                System.out.printf("%d ", array[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++)
            nums[i] = getRandomInt(0, 400);
        printArray(nums, 1);

        int highlight;
        do {
            System.out.print("\n\n¿Qué números quiere resaltar? (1 - los múltiplos de 5, 2 - los múltiplos de 7): ");
            highlight = s.nextInt();
        } while (highlight != 1 && highlight != 2);
        s.close();
        highlight = highlight == 1 ? 5 : 7;
        System.out.println();
        printArray(nums, highlight);
    }
}