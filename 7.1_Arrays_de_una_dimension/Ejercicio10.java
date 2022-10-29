
/**
 * Este programa genera 20 números enteros aleatorios entre 0 y 100 y los
 * almacena en un array. Es capaz de pasar todos los números pares a las
 * primeras posiciones del array (del 0 en adelante) y todos los números impares
 * a las celdas restantes. Utiliza arrays auxiliares si es necesario.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio10 {
    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return (randomInt);
    }

    public static void main(String[] args) {
        int[] originalArray = new int[20];
        int[] modifiedArray = new int[20];
        int randomNum;
        int countEven = 0;

        for (int i = 0; i < 20; i++) {
            randomNum = getRandomInt(0, 100);
            originalArray[i] = randomNum;
            if (randomNum % 2 == 0)
                countEven++;
        }

        int odd = countEven;
        int even = 0;

        System.out.print("\n Original     |");
        for (int i = 0; i < 20; i++) {
            System.out.printf(" %3d |", originalArray[i]);
            if (originalArray[i] % 2 == 0) {
                modifiedArray[even] = originalArray[i];
                even++;
            } else {
                modifiedArray[odd] = originalArray[i];
                odd++;
            }
        }
        System.out.print("\n Modificado   |");
        for (int i = 0; i < 20; i++)
            System.out.printf(" %3d |", modifiedArray[i]);
    }
}