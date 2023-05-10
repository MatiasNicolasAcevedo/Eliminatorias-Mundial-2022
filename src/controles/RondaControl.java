package controles;

import clases.*;
import enumeraciones.ResultadoEnum;
import utilidades.Utilidades;
import java.util.ArrayList;

public class RondaControl {

    Utilidades utilidades = new Utilidades();

    // recorremos la listaPartidos y agregamos los equipos + goles.
    public void cuartosDeFinal(ArrayList<Equipo> listaEquipos, ArrayList<Partido> listaPartidos) {

    int indiceEquipo1 = 0;  // para saber que equipo añadir al partido, sin repetir.
    int indiceEquipo2 = 1;

        for (int i = 0; i < listaPartidos.size(); i++) {  // recorre 4 veces, por cada partido le seteamos los datos.

            listaPartidos.get(i).setEquipo1(listaEquipos.get(indiceEquipo1));
            listaPartidos.get(i).setEquipo2(listaEquipos.get(indiceEquipo2));
            listaPartidos.get(i).setGolesEquipo1((int)Math.round(Math.random()*5));
            listaPartidos.get(i).setGolesEquipo2((int)Math.round(Math.random()*5));

            indiceEquipo1 += 2;  // se le suma 2 por que cada partido tiene 2 equipos.
            indiceEquipo2 += 2;
        }
    }

    // se analiza el partido (indicePartido), de acuerdo a los goles, se muestra GANADOR + setea avanza = true.
    public void avanzarRonda(ArrayList<Partido> listaPartidos, int indicePartido) {
        RondaControl rondaControl = new RondaControl();

        // obtenemos info del partido(indicePartido), para simplificar la lectura del codigo.
        String nombreEquipo1 = listaPartidos.get(indicePartido).getEquipo1().getNombre();
        String nombreEquipo2 = listaPartidos.get(indicePartido).getEquipo2().getNombre();
        int golesEquipo1 = listaPartidos.get(indicePartido).getGolesEquipo1();
        int golesEquipo2 = listaPartidos.get(indicePartido).getGolesEquipo2();

        // se evaluan los goles. alerta GANADOR + setea avanza = true.
        if (golesEquipo1 > golesEquipo2) {

            utilidades.alerta(nombreEquipo1 + " - " + ResultadoEnum.GANADOR,"Ha ganado y avanza de ronda");
            listaPartidos.get(indicePartido).getEquipo1().setAvanzaRonda(true);   // se le setea true al ganador.

        } else if (golesEquipo1 < golesEquipo2) {

            utilidades.alerta(nombreEquipo2 + " - " + ResultadoEnum.GANADOR,"Ha ganado y avanza de ronda");
            listaPartidos.get(indicePartido).getEquipo2().setAvanzaRonda(true);   // se le setea true al ganador.

        } else {  // en caso de empate mostramos alerta + llamamos al metodo desempatar() y le pasamos el indicePartido que necesitamos resolver.

            utilidades.alerta(nombreEquipo1 + " y " + nombreEquipo2 + " - " + ResultadoEnum.EMPATE,"Han Empatado - Se juega el desempate");
            rondaControl.desempatar(listaPartidos, indicePartido);
        }
    }

    // se recibe el partido que empato y se setean, goles + GANADOR + avanza = true.
    public void desempatar(ArrayList<Partido> listaPartidos, int indicePartido) {
        RondaControl rondaControl = new RondaControl();

        // mientras los golesEquipo1 == golesEquipo2 -> se setean nuevos goles.
        while (listaPartidos.get(indicePartido).getGolesEquipo1() == listaPartidos.get(indicePartido).getGolesEquipo2()) {
            listaPartidos.get(indicePartido).setGolesEquipo1((int)Math.round(Math.random()*5));
            listaPartidos.get(indicePartido).setGolesEquipo2((int)Math.round(Math.random()*5));
        }

        // obtenemos info del partido(indicePartido), para simplificar la lectura del codigo.
        int golesEquipo1 = listaPartidos.get(indicePartido).getGolesEquipo1();
        int golesEquipo2 = listaPartidos.get(indicePartido).getGolesEquipo2();
        String equipo1 = listaPartidos.get(indicePartido).getEquipo1().getNombre();
        String equipo2 = listaPartidos.get(indicePartido).getEquipo2().getNombre();

        // se muestra info. del partido de desempate.
        utilidades.alerta("Partido " + (indicePartido+1) + ": \n" +
                            equipo1 + " [ " + golesEquipo1 + " - " + golesEquipo2 + " ] " + equipo2,
                          " Partido " + (indicePartido+1) + " Desempate");

        // se evaluan los goles. alerta GANADOR + setea avanza = true.
        if (golesEquipo1 > golesEquipo2) {

            utilidades.alerta(equipo1 + " - " + ResultadoEnum.GANADOR,"Ha ganado y avanza de ronda");
            listaPartidos.get(indicePartido).getEquipo1().setAvanzaRonda(true);   // se le setea true al ganador.
        } else {

            utilidades.alerta(equipo2 + " - " + ResultadoEnum.GANADOR,"Ha ganado y avanza de ronda");
            listaPartidos.get(indicePartido).getEquipo2().setAvanzaRonda(true);   // se le setea true al ganador.
        }
    }

    // recorremos listaEquipos, los ganadores se cargan en listaPartidos + goles.
    public ArrayList<Partido> semiFinal(ArrayList<Equipo> listaEquipos, ArrayList<Partido> listaPartidos) {

        // usamos una lista como aux para almacenar los equipos true.
        ArrayList<Equipo> equiposSemis = new ArrayList<>();

        for (int i = 0; i < listaEquipos.size(); i++) {  // recorremos los equipos, buscando los true.
            if (listaEquipos.get(i).isAvanzaRonda()) {
                equiposSemis.add(listaEquipos.get(i));  // si es true, se agrega a lista equiposSemis.
                listaEquipos.get(i).setAvanzaRonda(false);  // seteamos de nuevo a false, hasta que vuelvan a ganar.
            }
        }
        // hard-codeamos los datos de semis (2 partidos). Desde la lista equiposSemis.
        listaPartidos.get(0).setEquipo1(equiposSemis.get(0));
        listaPartidos.get(0).setEquipo2(equiposSemis.get(1));
        listaPartidos.get(0).setGolesEquipo1((int)Math.round(Math.random()*5));
        listaPartidos.get(0).setGolesEquipo2((int)Math.round(Math.random()*5));

        listaPartidos.get(1).setEquipo1(equiposSemis.get(2));
        listaPartidos.get(1).setEquipo2(equiposSemis.get(3));
        listaPartidos.get(1).setGolesEquipo1((int)Math.round(Math.random()*5));
        listaPartidos.get(1).setGolesEquipo2((int)Math.round(Math.random()*5));

        return listaPartidos;
    }

    // recorremos listaEquipos, los ganadores se cargan en listaPartidos + goles.
    public void partidoFinal(ArrayList<Equipo> listaEquipos, ArrayList<Partido> listaPartidos) {

        // usamos una lista como aux para almacenar los equipos true.
        ArrayList<Equipo> equiposFinal = new ArrayList<>();

        for (int i = 0; i < listaEquipos.size(); i++) {  // recorremos los equipos, buscando los true.
            if (listaEquipos.get(i).isAvanzaRonda()) {
                equiposFinal.add(listaEquipos.get(i));    // si es true, se agrega a lista equiposFinal.
            }
        }
        // hard-codeamos los datos de la final. Desde la lista equiposFinal.
        listaPartidos.get(0).setEquipo1(equiposFinal.get(0));
        listaPartidos.get(0).setEquipo2(equiposFinal.get(1));
        listaPartidos.get(0).setGolesEquipo1((int)Math.round(Math.random()*5));
        listaPartidos.get(0).setGolesEquipo2((int)Math.round(Math.random()*5));
    }

    // mostramos la info. del equipo ganador. + descripcion(DT).
    public void ganador(ArrayList<Partido> listaPartidos) {

        // se evalua el equipo con mas goles, y se muestra mensaje final.
        if (listaPartidos.get(0).getGolesEquipo1() > listaPartidos.get(0).getGolesEquipo2()) {
            utilidades.alerta("FELICITACIONES - [ " + listaPartidos.get(0).getEquipo1().getNombre() + " ] - " + listaPartidos.get(0).getEquipo1().getDescripcion() + " --> POR GANAR EL MUNDIAL DE QATAR 2022", "QATAR 2022");
        } else {
            utilidades.alerta("FELICITACIONES - [ " + listaPartidos.get(0).getEquipo2().getNombre() + " ] - " + listaPartidos.get(0).getEquipo2().getDescripcion() + " --> POR GANAR EL MUNDIAL DE QATAR 2022", "QATAR 2022");
        }
    }
}
