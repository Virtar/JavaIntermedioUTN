package TendenciasMusicales;

public class EstadoNormal extends Estado {

    @Override
    public String popularidad(Cancion cancion) {
        return Icono.MUSICAL_NOTE.texto()+cancion.getArtista()
                +" - "+cancion.getAlbum()
                +" – "+cancion.getTitulo();
    }
}
