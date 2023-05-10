package controles;

import clases.*;
import javax.swing.*;
import java.util.ArrayList;

public class EquipoControl {

    // se cargan 8 equipos en la listaEquipos.
    public ArrayList<Equipo> cargarEquipos(ArrayList<Equipo> listaEquipos) {

        listaEquipos.add(new Equipo("Argentina", "DT - Lionel Scaloni"));
        listaEquipos.add(new Equipo("Países Bajos", "DT - Louis Van Gaal"));
        listaEquipos.add(new Equipo("Croacia", "DT - Zlatko Dalic"));
        listaEquipos.add(new Equipo("Brasil", "DT - Tite"));
        listaEquipos.add(new Equipo("Inglaterra", "DT - Gareth Southgate"));
        listaEquipos.add(new Equipo("Francia", "DT - Didier Deschamps"));
        listaEquipos.add(new Equipo("Marruecos", "DT - Walid Regragui"));
        listaEquipos.add(new Equipo("Portugal", "DT - Fernando Santos"));

        return listaEquipos;
    }

    // se muestra una alerta con todos los equipos.
    public void mostrarMensajeEquipos(ArrayList<Equipo> listaEquipos) {

        String mensaje = "";
        for (int i = 0; i < listaEquipos.size(); i++) {
            mensaje += (i+1) + " - " + listaEquipos.get(i).getNombre() + "\n";  // se concatena los nombres de los equipos para enviar como mensaje en la alerta.
        }
        JOptionPane.showMessageDialog(null, mensaje, "Lista de Equipos:", JOptionPane.INFORMATION_MESSAGE);
    }
}
