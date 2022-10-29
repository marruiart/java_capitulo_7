/**
 * En este programa se define un array de 12 números enteros con nombre num y se
 * asignan algunos valores. Al mostrar el contenido de todos los elementos del
 * array, los que no han sido inicializados previamente contienen 0.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] num = new int[12];
        num[0] = 39;
        num[1] = -2;
        num[4] = 0;
        num[6] = 14;
        num[8] = 5;
        num[9] = 120;

        for (int i = 0; i < 12; i++)
            System.out.printf("%d ", num[i]);
    }
}