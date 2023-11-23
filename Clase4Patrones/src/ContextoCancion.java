public class ContextoCancion {

    private String nombreCancion;
    private String artista;
    private String album;
    private int anio;
    private int reproducciones;
    private int likes;
    private int dislikes;
    private int ultimaReproEnMins;
    private Estado estado;

    public ContextoCancion() {
        this.estado = new EstadoNormal();
    }

    public ContextoCancion(String nombreCancion, String artista, String album, int anio) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.album = album;
        this.anio = anio;
        this.reproducciones = 0;
        this.likes = 0;
        this.dislikes = 0;
        this.ultimaReproEnMins = -1;
        this.estado = new EstadoNormal();
    }
    public ContextoCancion(String nombreCancion, String artista, String album, int anio, int reproducciones, int likes, int dislikes, int ultimaReproEnMins, Estado estado) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.album = album;
        this.anio = anio;
        this.reproducciones = reproducciones;
        this.likes = likes;
        this.dislikes = dislikes;
        this.ultimaReproEnMins = ultimaReproEnMins;
        this.estado = new EstadoNormal();
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getUltimaReproEnMins() {
        return ultimaReproEnMins;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }
    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getAnio() {
        return anio;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setUltimaReproEnMins(int ultimaReproEnMins) {
        this.ultimaReproEnMins = ultimaReproEnMins;
    }

    public void actuar()
    {
        this.estado.actuar(this);
    }

    public void cambiarEstado(Estado estado)
    {
        this.estado = estado;
    }

    public void mostrarInfo()
    {
        this.estado.escribirLeyenda(this);
    }
}
