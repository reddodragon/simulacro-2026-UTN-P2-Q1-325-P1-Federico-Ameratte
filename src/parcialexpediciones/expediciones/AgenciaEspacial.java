package parcialexpediciones.expediciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgenciaEspacial {

    private ArrayList<Nave> naves;

    public AgenciaEspacial() {
        naves = new ArrayList<>();
    }

    public void agregarNave(Nave nave) {
        if (naves.contains(nave)) {
            System.out.println("Ya existe una nave con ese nombre y anio de lanzamiento.");
        } else {
            naves.add(nave);
            System.out.println("Nave agregada correctamente.");
        }
    }

    public void mostrarNaves() {
        if (naves.isEmpty()) {
            System.out.println("No hay naves registradas.");
        } else {
            for (Nave nave : naves) {
                nave.mostrarInformacion();
            }
        }
    }

    public void iniciarExploracion() {
        if (naves.isEmpty()) {
            System.out.println("No hay naves registradas.");
        } else {
            for (Nave nave : naves) {

                if (nave instanceof Explorable) {
                    Explorable explorable = (Explorable) nave;
                    explorable.iniciarExploracion();
                } else {
                    System.out.println("El crucero estelar " + nave.getNombre()
                            + " no puede participar en misiones de exploracion.");
                }
            }
        }
    }

public void mostrarOrdenadasPorNombre() {
    if (naves.isEmpty()) {
        System.out.println("No hay naves registradas.");
        return;
    }

    ArrayList<Nave> copia = new ArrayList<>(naves);

    Collections.sort(copia);

    for (Nave nave : copia) {
        nave.mostrarInformacion();
    }
}

    public void mostrarOrdenadasPorAnio() {
        if (naves.isEmpty()) {
            System.out.println("No hay naves registradas.");
            return;
        }

        ArrayList<Nave> copia = new ArrayList<>(naves);

        Collections.sort(copia, new Comparator<Nave>() {
            @Override
            public int compare(Nave n1, Nave n2) {
                return n2.getAnioLanzamiento() - n1.getAnioLanzamiento();
            }
        });

        for (Nave nave : copia) {
            nave.mostrarInformacion();
        }
    }

    public void mostrarOrdenadasPorTripulacion() {
        if (naves.isEmpty()) {
            System.out.println("No hay naves registradas.");
            return;
        }

        ArrayList<Nave> copia = new ArrayList<>(naves);

        Collections.sort(copia, new Comparator<Nave>() {
            @Override
            public int compare(Nave n1, Nave n2) {
                return n2.getCapacidadTripulacion() - n1.getCapacidadTripulacion();
            }
        });

        for (Nave nave : copia) {
            nave.mostrarInformacion();
        }
    }
}