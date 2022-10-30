/**
 * Este programa rellena un array de 15 elementos con números enteros
 * comprendidos entre 0 y 500 (ambos incluidos). A continuación, se mostrará el
 * array “cincuerizado”, según el siguiente criterio: si el número que hay en
 * una posición del array es múltiplo de 5, se deja igual, y si no, se cambia
 * por el siguiente múltiplo de 5 que exista a partir de él.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio21 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return randomInt;
    }

    public static void cincuerizing(int num, int[] modifiedArray, int position) {
        int tmp = num + 5;
        if (num % 5 == 0)
            modifiedArray[position] = num;
        else
            while (num++ < tmp)
                if (num % 5 == 0)
                    modifiedArray[position] = num;
    }

    public static void main(String[] args) {
        int arrayLength = 15;
        int[] originalArray = new int[arrayLength];
        int[] modifiedArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int num = getRandomInt(0, 500);
            originalArray[i] = num;
        }

        System.out.println("\nARRAY INICIAL");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf("%3d ", originalArray[i]);
        System.out.println("\nARRAY FINAL");
        for (int i = 0; i < arrayLength; i++) {
            cincuerizing(originalArray[i], modifiedArray, i);
            System.out.printf("%3d ", modifiedArray[i]);
        }
    }
}