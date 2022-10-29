/**
 * En este programa se define un array de 10 caracteres con nombre simbolo y se
 * asigna valores a algunos elementos. Al mostrar el contenido del array
 * completo, los elementos que no han sido inicializados contienen 'null'
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio2 {
    public static void main(String[] args) {
        String[] simbolo = new String[12];
        simbolo[0] = "a";
        simbolo[1] = "x";
        simbolo[4] = "@";
        simbolo[6] = " ";
        simbolo[7] = "+";
        simbolo[8] = "Q";

        for (int i = 0; i < 12; i++)
            System.out.printf("%s ", simbolo[i]);
    }
}