package controles;

import clases.*;
import utilidades.Utilidades;
import java.util.ArrayList;

public class PartidoControl {

    // se carga la lista partidos con la cantidad de partidos que necesitamos.
    public ArrayList<Partido> cargarPartidos(ArrayList<Partido> listaPartidos, int cantidadPartidos) {

        for (int i = 0; i < cantidadPartidos; i++) {
            listaPartidos.add(new Partido());
        }
        return listaPartidos;
    }

    // recorremos listaPartidos y mostramos el alerta con la info de cada partido.
    public void mostrarAlertaPartidos(ArrayList<Partido> listaPartidos, String titulo) {
        Utilidades utilidades = new Utilidades();
        RondaControl rondaControl = new RondaControl();

        for (int i = 0; i < listaPartidos.size(); i++) {

            utilidades.alerta("Partido " + (i+1) + ": \n" +
                            listaPartidos.get(i).getEquipo1().getNombre() +
                    " [ " + listaPartidos.get(i).getGolesEquipo1() +
                    " - " + listaPartidos.get(i).getGolesEquipo2() +
                    " ] " + listaPartidos.get(i).getEquipo2().getNombre(), titulo + (i+1));

            listaPartidos.get(i).getEquipo1().setAvanzaRonda(false);  // se setea false, para asegurar que no viene con un true de ronda anterior.
            listaPartidos.get(i).getEquipo2().setAvanzaRonda(false);

            // se calcula que equipos avanzan de ronda, GANADOR = true.
            rondaControl.avanzarRonda(listaPartidos, i);  // le pasamos i, para saber en que partido estamos posicionados.
        }
    }
}
