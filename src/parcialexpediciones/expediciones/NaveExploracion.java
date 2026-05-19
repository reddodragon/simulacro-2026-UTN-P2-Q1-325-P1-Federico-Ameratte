package parcialexpediciones.expediciones;


public class NaveExploracion extends Nave implements Explorable {


    private String tipoMision;


    public NaveExploracion(String nombre, int capacidadTripulacion, int anioLanzamiento, String tipoMision) {
        

        super(nombre, capacidadTripulacion, anioLanzamiento);
        
        this.tipoMision = tipoMision;
    }

    public String getTipoMision() {
        return tipoMision;
    }

    @Override
    public void iniciarExploracion() {
        System.out.println("La nave de exploracion " + getNombre()
                + " inicia mision de " + tipoMision);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nave de Exploracion");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Capacidad de tripulacion: " + getCapacidadTripulacion());
        System.out.println("Anio de lanzamiento: " + getAnioLanzamiento());
        System.out.println("Tipo de mision: " + tipoMision);
        System.out.println("----------------------------------");
    }
}