package clases;

import java.util.ArrayList;

public class Ronda {

    private String numeroRonda;
    private ArrayList<Partido> partidos = new ArrayList<>();

    public Ronda() {
    }

    public Ronda(String numeroRonda, ArrayList<Partido> partidos) {
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    public String getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(String numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}
