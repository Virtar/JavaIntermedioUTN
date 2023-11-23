package TendenciasMusicales;

public class EstadoEnTendencia extends Estado {
    @Override
    public String popularidad(Cancion cancion) {
        return Icono.FIRE.texto()+cancion.getTitulo()
                +" - "+cancion.getArtista()
                +" ("+cancion.getAlbum()
                +" - "+cancion.getYear()
                +")";
    }
}
