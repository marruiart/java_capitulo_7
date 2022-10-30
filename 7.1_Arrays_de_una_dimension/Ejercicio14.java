
/**
 * Este programa pide 8 palabras y las almacene en un array. A
 * continuación, las palabras correspondientes a colores se deben almacenar al
 * comienzo y las que no son colores a continuación. Los colores que conoce el
 * programa deben estar en otro array y son los siguientes: verde, rojo, azul,
 * amarillo, naranja, rosa, negro, blanco y morado.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio14 {

    public static boolean isColour(String word) {
        String[] colours = { "verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco", "morado" };
        boolean wordIsColour = false;
        for (int i = 0; i < colours.length; i++)
            if (word.equals(colours[i]))
                wordIsColour = true;
        return wordIsColour;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word;
        String[] originalArray = new String[8];
        String[] modifiedArray = new String[8];
        String[] tmpArray = new String[8];
        int position = 0;
        int modifiedPosition = 0;
        int tmpPosition = 0;
        int countColours = 0;

        do {
            System.out.printf("%d - Introduzca una palabra o un color (máximo 10 letras): ", position + 1);
            word = s.next();
            originalArray[position] = word;
            if (isColour(word)) {
                modifiedArray[modifiedPosition] = word;
                modifiedPosition++;
                countColours++;
            } else {
                tmpArray[tmpPosition] = word;
                tmpPosition++;
            }
            position++;
        } while (position < 8);
        s.close();

        System.out.print("\nARRAY INICIAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 8; i++)
            System.out.printf(" %10d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 8; i++)
            System.out.printf(" %10s |", originalArray[i]);

        System.out.print("\nARRAY FINAL");
        System.out.print("\n| Índice     |");
        for (int i = 0; i < 8; i++)
            System.out.printf(" %10d |", i);
        System.out.print("\n| Valor      |");
        for (int i = 0; i < 8; i++) {
            if (i + countColours < 8)
                modifiedArray[i + countColours] = tmpArray[i];
            System.out.printf(" %10s |", modifiedArray[i]);
        }
    }
}
