package parcialexpediciones.expediciones;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AgenciaEspacial agencia = new AgenciaEspacial();

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("===== SISTEMA DE EXPEDICIONES ESPACIALES =====");
            System.out.println("1. Agregar nave");
            System.out.println("2. Mostrar todas las naves");
            System.out.println("3. Iniciar mision de exploracion");
            System.out.println("4. Mostrar naves ordenadas por nombre");
            System.out.println("5. Mostrar naves ordenadas por anio de lanzamiento");
            System.out.println("6. Mostrar naves ordenadas por capacidad de tripulacion");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    agregarNaveDesdeMenu(sc, agencia);
                    break;

                case 2:
                    agencia.mostrarNaves();
                    break;

                case 3:
                    agencia.iniciarExploracion();
                    break;

                case 4:
                    agencia.mostrarOrdenadasPorNombre();
                    break;

                case 5:
                    agencia.mostrarOrdenadasPorAnio();
                    break;

                case 6:
                    agencia.mostrarOrdenadasPorTripulacion();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            System.out.println();
        }

        sc.close();
    }

    public static void agregarNaveDesdeMenu(Scanner sc, AgenciaEspacial agencia) {

        System.out.println("Seleccione tipo de nave:");
        System.out.println("1. Nave de Exploracion");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero Estelar");
        System.out.print("Tipo: ");

        int tipo = leerEntero(sc);

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return;
        }

        System.out.print("Capacidad de tripulacion: ");
        int capacidadTripulacion = leerEntero(sc);

        if (capacidadTripulacion <= 0) {
            System.out.println("La capacidad de tripulacion debe ser mayor a cero.");
            return;
        }

        System.out.print("Anio de lanzamiento: ");
        int anioLanzamiento = leerEntero(sc);

        if (anioLanzamiento <= 0) {
            System.out.println("El anio de lanzamiento debe ser mayor a cero.");
            return;
        }

        switch (tipo) {
            case 1:
                agregarNaveExploracion(sc, agencia, nombre, capacidadTripulacion, anioLanzamiento);
                break;

            case 2:
                agregarCarguero(sc, agencia, nombre, capacidadTripulacion, anioLanzamiento);
                break;

            case 3:
                agregarCruceroEstelar(sc, agencia, nombre, capacidadTripulacion, anioLanzamiento);
                break;
        }
    }

    public static void agregarNaveExploracion(Scanner sc, AgenciaEspacial agencia,
            String nombre, int capacidadTripulacion, int anioLanzamiento) {

        System.out.println("Tipo de mision:");
        System.out.println("1. CARTOGRAFIA");
        System.out.println("2. INVESTIGACION");
        System.out.println("3. CONTACTO");
        System.out.print("Opcion: ");

        int opcionMision = leerEntero(sc);
        String tipoMision;

        if (opcionMision == 1) {
            tipoMision = "CARTOGRAFIA";
        } else if (opcionMision == 2) {
            tipoMision = "INVESTIGACION";
        } else if (opcionMision == 3) {
            tipoMision = "CONTACTO";
        } else {
            System.out.println("Tipo de mision invalido.");
            return;
        }

        NaveExploracion nave = new NaveExploracion(
                nombre,
                capacidadTripulacion,
                anioLanzamiento,
                tipoMision
        );

        agencia.agregarNave(nave);
    }

    public static void agregarCarguero(Scanner sc, AgenciaEspacial agencia,
            String nombre, int capacidadTripulacion, int anioLanzamiento) {

        System.out.print("Capacidad de carga en toneladas: ");
        int capacidadCarga = leerEntero(sc);

        if (capacidadCarga < 100 || capacidadCarga > 500) {
            System.out.println("Valor fuera de rango. Intente nuevamente.");
            return;
        }

        Carguero carguero = new Carguero(
                nombre,
                capacidadTripulacion,
                anioLanzamiento,
                capacidadCarga
        );

        agencia.agregarNave(carguero);
    }

    public static void agregarCruceroEstelar(Scanner sc, AgenciaEspacial agencia,
            String nombre, int capacidadTripulacion, int anioLanzamiento) {

        System.out.print("Cantidad de pasajeros: ");
        int cantidadPasajeros = leerEntero(sc);

        if (cantidadPasajeros <= 0) {
            System.out.println("La cantidad de pasajeros debe ser mayor a cero.");
            return;
        }

        CruceroEstelar crucero = new CruceroEstelar(
                nombre,
                capacidadTripulacion,
                anioLanzamiento,
                cantidadPasajeros
        );

        agencia.agregarNave(crucero);
    }

    public static int leerEntero(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.println("Ingrese un numero valido.");
            sc.nextLine();
            System.out.print("Ingrese nuevamente: ");
        }

        int numero = sc.nextInt();
        sc.nextLine();

        return numero;
    }

    public static double leerDouble(Scanner sc) {

        while (!sc.hasNextDouble()) {
            System.out.println("Ingrese un numero valido.");
            sc.nextLine();
            System.out.print("Ingrese nuevamente: ");
        }

        double numero = sc.nextDouble();
        sc.nextLine();

        return numero;
    }
}