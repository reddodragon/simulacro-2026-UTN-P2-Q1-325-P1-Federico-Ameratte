package parcialexpediciones.expediciones;

public class CruceroEstelar extends Nave {

    private int cantidadPasajeros;

    public CruceroEstelar(String nombre, int capacidadTripulacion, int anioLanzamiento, int cantidadPasajeros) {

        super(nombre, capacidadTripulacion, anioLanzamiento);

        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Crucero Estelar");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Capacidad de tripulacion: " + getCapacidadTripulacion());
        System.out.println("Anio de lanzamiento: " + getAnioLanzamiento());
        System.out.println("Cantidad de pasajeros: " + cantidadPasajeros);
        System.out.println("----------------------------------");
    }
}