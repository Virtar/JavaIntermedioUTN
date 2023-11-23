package TendenciasMusicales;

public class EstadoEnAuge extends Estado {
    @Override
    public String popularidad(Cancion cancion) {
        return Icono.ROCKET.texto()+cancion.getArtista()
                +" - "+cancion.getTitulo()
                +" ("+cancion.getAlbum()
                +" - "+cancion.getYear()
                +")";
    }
}
