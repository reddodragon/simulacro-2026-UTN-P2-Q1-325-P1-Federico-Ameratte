package parcialexpediciones.expediciones;

public abstract class Nave implements Comparable<Nave> {

    private String nombre;
    private int capacidadTripulacion;
    private int anioLanzamiento;

    public Nave(String nombre, int capacidadTripulacion, int anioLanzamiento) {
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }


    public abstract void mostrarInformacion();


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Nave) {
            Nave otra = (Nave) obj;
            return this.nombre.equalsIgnoreCase(otra.nombre)
                    && this.anioLanzamiento == otra.anioLanzamiento;
        }

        return false;
    }


    @Override
    public int compareTo(Nave otra) {
        return this.nombre.compareToIgnoreCase(otra.nombre);
    }
}