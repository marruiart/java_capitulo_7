
/**
 * Este programa pide la temperatura media que ha hecho en cada mes
 * de un determinado año y muestra a continuación un diagrama de barras
 * horizontales con esos datos. Las barras del diagrama se pueden dibujar a base
 * de asteriscos o cualquier otro carácter.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] avgTemperatures = new int[12];
        String[] months = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
                "octubre", "noviembre", "diciembre" };

        int month = 0;
        do {
            System.out.printf("Introduzca la temperatura media en el mes de %s: ", months[month]);
            int temperature = s.nextInt();
            if (temperature >= -9 && temperature <= 45) {
                avgTemperatures[month] = temperature;
                month++;
            } else
                System.out.println("La temperatura media debe ser de -9 a 45ºC.");
        } while (month < 12);
        s.close();

        for (month = -1; month < 12; month++) {
            if (month == -1) {
                System.out.printf("%10s | ", "ºC");
                for (int i = -9; i <= 45; i++) {
                    if (i % 5 == 0)
                        System.out.printf("%2d", i);
                    else
                        System.out.print("  ");
                }
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            } else {
                System.out.printf("%10s | ", months[month]);
                for (int i = -9; i <= 45; i++) {
                    if (avgTemperatures[month] >= i && i >= 0)
                        System.out.print(" |");
                    else if (avgTemperatures[month] <= i && i <= 0)
                        System.out.print(" |");
                    else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
    }
}