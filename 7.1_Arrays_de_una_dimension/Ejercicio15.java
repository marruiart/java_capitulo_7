
/**
 * Este programa coloca a los clientes de un restaurante en
 * sus mesas. En una mesa se pueden sentar de 0 (mesa vacía) a 4 comensales
 * (mesa llena). Cuando llega un cliente se le pregunta cuántos son. De momento
 * el programa no está preparado para colocar a grupos mayores a 4, por tanto,
 * si un cliente dice por ejemplo que son un grupo de 6, el programa dará el
 * mensaje “Lo siento, no admitimos grupos de 6, haga grupos de 4 personas
 * como máximo e intente de nuevo”. Para el grupo que llega, se busca
 * siempre la primera mesa libre (con 0 personas). Si no quedan mesas libres, se
 * busca donde haya un hueco para todo el grupo, por ejemplo si el grupo es de
 * dos personas, se podrá colocar donde haya una o dos personas. Inicialmente,
 * las mesas se cargan con valores aleatorios entre 0 y 4. Cada vez que se
 * sientan nuevos clientes se debe mostrar el estado de las mesas. Los grupos no
 * se pueden romper aunque haya huecos sueltos suficientes.
 *
 * @author: Marina Ruiz Artacho
 **/

import java.util.Scanner;

public class Ejercicio15 {

    public static void findFreeTable(int[] tables, int persons) {
        int table = -1;
        for (int i = 0; i < 10; i++)
            if (tables[i] == 0) {
                table = i;
                tables[table] += persons;
                System.out.printf("Por favor, siéntense en la mesa número %d.\n", table + 1);
                return;
            }
        for (int i = 0; i < 10; i++)
            if (tables[i] + persons <= 4) {
                table = i;
                tables[table] += persons;
                System.out.printf("Tendrán que compartir mesa. Por favor, siéntense en la mesa número %d.\n",
                        table + 1);
                return;
            }
        if (table == -1)
            System.out.print("Lo siento, en estos momentos no queda sitio.\n");
    }

    public static void printTables(int[] tables) {
        System.out.print("\n Mesa nº   |");
        for (int i = 1; i <= 10; i++)
            System.out.printf(" %2d |", i);
        System.out.print("\n Ocupación |");
        for (int i = 0; i < 10; i++)
            System.out.printf(" %2d |", tables[i]);
        System.out.println("\n");
    }

    public static int getRandomInt(int min, int max) {
        int randomInt = min + (int) (Math.random() * ((max - min) + 1));
        return (randomInt);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int persons = 0;
        int[] tables = new int[10];

        for (int i = 0; i < 10; i++)
            tables[i] = getRandomInt(0, 4);
        printTables(tables);

        do {
            if (persons > 0 && persons <= 4) {
                findFreeTable(tables, persons);
                printTables(tables);
            }
            System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
            persons = s.nextInt();
            if (persons > 4)
                System.out.printf(
                        "Lo siento, no admitimos grupos de %d, haga grupos de 4 personas como máximo e intente de nuevo.\n",
                        persons);
        } while (persons > 0);
        s.close();
    }
}