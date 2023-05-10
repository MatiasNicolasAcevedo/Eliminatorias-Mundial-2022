package utilidades;

import javax.swing.*;

public class Utilidades {

    public void alerta(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
