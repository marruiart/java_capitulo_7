
/**
 * Este programa rellena un array de 100 elementos con números enteros
 * aleatorios comprendidos entre 0 y 500 (ambos incluidos). A continuación
 * el programa muestra el array y pregunta si el usuario quiere destacar el
 * máximo o el mínimo. Seguidamente se volverá a mostrar el array escribiendo
 * el número destacado entre dobles asteriscos.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio13 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return (randomInt);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] randomNums = new int[100];
        int min = (int) (Math.pow(2, 32) - 1);
        int max = (int) (Math.pow(2, 32)) * (-1) - 1;

        for (int i = 0; i < 100; i++) {
            randomNums[i] = getRandomInt(0, 500);
            System.out.printf("%d ", randomNums[i]);
            if (randomNums[i] < min)
                min = randomNums[i];
            else if (randomNums[i] > max)
                max = randomNums[i];
        }

        System.out.print("\n\n¿Qué quiere destacar? (1 - mínimo, 2 - máximo, 3 - ambos): ");
        int highlight = s.nextInt();
        s.close();

        System.out.println();
        for (int i = 0; i < 100; i++) {
            if ((highlight == 1 || highlight == 3) && randomNums[i] == min)
                System.out.printf("**%d** ", randomNums[i]);
            else if ((highlight == 2 || highlight == 3) && randomNums[i] == max)
                System.out.printf("**%d** ", randomNums[i]);
            else
                System.out.printf("%d ", randomNums[i]);
        }
    }
}