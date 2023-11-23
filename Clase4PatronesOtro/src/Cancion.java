package TendenciasMusicales;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Cancion {
    private String artista;
    private String titulo;
    private String album;
    private int year;
    private int reproducciones = 1;
    private int likes = 0;
    private int dislikes = 0;
    private boolean reproducidaEnLasUltimas24Horas = true;
    private Estado estado = new EstadoNormal();
    public Cancion(String artista, String titulo, String album, int year){
        this.artista = artista;
        this.titulo = titulo;
        this.album = album;
        this.year = year;
        estado.cambiarEstado(this);
    }

    public String getEstadoPopularidad() {
        estado.cambiarEstado(this);
        return estado.popularidad(this);
    }
}
