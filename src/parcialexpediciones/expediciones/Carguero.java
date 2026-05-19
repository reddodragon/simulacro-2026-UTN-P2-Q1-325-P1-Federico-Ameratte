package parcialexpediciones.expediciones;

public class Carguero extends Nave implements Explorable {

    private int capacidadCarga;

    public Carguero(String nombre, int capacidadTripulacion, int anioLanzamiento, int capacidadCarga) {

        super(nombre, capacidadTripulacion, anioLanzamiento);

        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public void iniciarExploracion() {
        System.out.println("El carguero " + getNombre()
                + " inicia mision de exploracion transportando suministros.");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Carguero");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Capacidad de tripulacion: " + getCapacidadTripulacion());
        System.out.println("Anio de lanzamiento: " + getAnioLanzamiento());
        System.out.println("Capacidad de carga: " + capacidadCarga + " toneladas");
        System.out.println("----------------------------------");
    }
}