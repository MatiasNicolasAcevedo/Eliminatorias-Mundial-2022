import clases.*;
import controles.*;
import utilidades.Utilidades;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Utilidades utilidades = new Utilidades();
        EquipoControl equipoControl = new EquipoControl();
        PartidoControl partidoControl = new PartidoControl();
        RondaControl rondaControl = new RondaControl();

        // se envia alerta de bienvenida. -> se pasa como argumentos, (String) el cuerpo de mensaje, y (String) el titulo.
        utilidades.alerta("[ INICIO ]","INICIO DEL PROGRAMA");
        utilidades.alerta("Bienvenidos - Han comenzado las Eliminatorias", "MUNDIAL QATAR 2022");

        // creamos lista <Equipo> para guardar los equipos.
        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        // se cargan en la listaEquipos los 8 equipos iniciales.
        equipoControl.cargarEquipos(listaEquipos);

        // se muestra alerta con la listaEquipos.
        equipoControl.mostrarMensajeEquipos(listaEquipos);

        // se envia alerta cuartos de final.
        utilidades.alerta("Se juegan los cuartos de final", "CUARTOS DE FINAL");

        // creamos la lista para guardar los partidos.
        ArrayList<Partido> listaPartidos = new ArrayList<>();

        // se cargan en listaPartidos, 4 partidos (en cuartos se juegan 4 partidos). 2do Argumento, la cantidad de partidos.
        partidoControl.cargarPartidos(listaPartidos, 4);  // cargarPartidos() -> [1er Uso].

        // se carga la ronda de cuartos: partidos: equipos + goles.
        rondaControl.cuartosDeFinal(listaEquipos, listaPartidos);

        // mostrar alerta de partidos cuartos de final. + llamada interna avanzarRonda().
        partidoControl.mostrarAlertaPartidos(listaPartidos, " Cuartos de Final ");  // mostrarAlertaPartidos() -> [1er Uso].

        // vaciar lista, para cargar las semi-final.
        listaPartidos.clear();

        // se cargan en listaPartidos, 2 partidos (en semifinal se juegan 2 partidos). 2do Argumento, la cantidad de partidos.
        partidoControl.cargarPartidos(listaPartidos, 2);  // cargarPartidos() -> [2do Uso].

        // se carga la ronda de semi-final: equipos + goles.
        rondaControl.semiFinal(listaEquipos,listaPartidos);

        // se envia alerta semifinal.
        utilidades.alerta("Se juegan las semifinales", "SEMIFINAL");

        // mostrar alerta de partidos semifinal. + llamada interna avanzarRonda().
        partidoControl.mostrarAlertaPartidos(listaPartidos, " SemiFinal ");  // mostrarAlertaPartidos() -> [2do Uso].

        // vaciar lista, para cargar la final.
        listaPartidos.clear();

        // se carga en la listaPartidos, 1 partido (la final).  2do Argumento, la cantidad de partidos.
        partidoControl.cargarPartidos(listaPartidos, 1);  // cargarPartidos() -> [3er Uso].

        // se setea el partido final.
        rondaControl.partidoFinal(listaEquipos,listaPartidos);

        // se envia alerta partido final.
        utilidades.alerta("Se juega la final", "FINAL");

        // mostrar alerta de partido final.  + llamada interna avanzarRonda().
        partidoControl.mostrarAlertaPartidos(listaPartidos, " Final ");  // mostrarAlertaPartidos() -> [3er Uso].

        // mostrar alerta GANADOR + DT.
        rondaControl.ganador(listaPartidos);

        utilidades.alerta("[ FIN ]","FIN DEL PROGRAMA");
    }
}
