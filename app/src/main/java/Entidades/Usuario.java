package Entidades;

import java.util.Comparator;

public class Usuario implements Comparable<Usuario> {
    private String Nickname;
    private String Dificultad;
    private int Puntuacion;

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getDificultad() {
        return Dificultad;
    }

    public void setDificultad(String dificultad) {
        Dificultad = dificultad;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        Puntuacion = puntuacion;
    }
    @Override
    public String toString() {
        return this.Nickname;
    }

    @Override
    public int compareTo(Usuario usuario) {
        return 0;
    }
}
