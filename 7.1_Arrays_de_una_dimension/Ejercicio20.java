
/**
 * Este programa calcula la denominación ordinal de los reyes de una secuencia
 * histórica. El programa solicita la cantidad de reyes que se van a introducir,
 * y a continuación recibirá los nombres de los reyes. Presentará por pantalla
 * dichos nombres, pero colocándoles el ordinal correspondiente. Así, por
 * ejemplo, si hay dos Felipes en los nombres de los reyes, el primero
 * debería aparecer como Felipe 1º y el segundo como Felipe 2º.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio20 {

    public static int getTimesRepeated(String[] array, int position) {
        int repetitions = 0;
        String item = array[position];
        for (int i = 0; i <= position; i++) {
            if (item.equals(array[i]))
                repetitions++;
        }
        return repetitions;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el número total de nombres de reyes: ");
        int total = s.nextInt();
        String[] kings = new String[total];
        int[] kingsNumber = new int[total];
        System.out.println("Vaya introduciendo los nombres de los reyes y pulsando INTRO.");
        for (int i = 0; i < total; i++) {
            System.out.printf("Rey %d: ", i + 1);
            kings[i] = s.next();
            kingsNumber[i] = getTimesRepeated(kings, i);
        }
        s.close();

        System.out.println("Los reyes introducidos son:");
        for (int i = 0; i < total; i++)
            System.out.printf("%s %dº\n", kings[i], kingsNumber[i]);
    }
}