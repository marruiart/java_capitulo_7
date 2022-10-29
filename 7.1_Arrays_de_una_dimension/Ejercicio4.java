/**
 * En este programa se definen tres arrays de 20 números enteros cada uno, con
 * nombres numero, cuadrado y cubo. El array se carga con números con valores
 * aleatorios entre 0 y 100.
 * En el array cuadrado se almacenan los cuadrados de los valores que hay en el
 * array numero. En el array cubo se almacenan los cubos de los valores que hay
 * en numero. A continuación, muestra el contenido de los tres arrays dispuesto
 * en tres columnas.
 *
 * @author: Marina Ruiz Artacho
 **/

public class Ejercicio4 {

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return (randomInt);
    }

    public static void main(String[] args) {
        int[] numero = new int[20];
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];
        int randomNum;

        for (int i = 0; i < 20; i++) {
            randomNum = getRandomInt(0, 100);
            numero[i] = randomNum;
            cuadrado[i] = (int) Math.pow(randomNum, 2);
            cubo[i] = (int) Math.pow(randomNum, 3);
        }

        System.out.println("----------------------------------");
        System.out.printf("| %8s | %8s | %8s |\n", "numero", "cuadrado", "cubo");
        System.out.println("|--------------------------------|");
        for (int i = 0; i < 20; i++) {
            System.out.printf("| %8d | %8d | %8d |\n", numero[i], cuadrado[i], cubo[i]);
        }
        System.out.println("----------------------------------");
    }
}