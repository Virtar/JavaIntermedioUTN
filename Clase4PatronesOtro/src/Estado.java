package TendenciasMusicales;

public abstract class Estado {
    public abstract String popularidad(Cancion cancion);
    public void cambiarEstado(Cancion cancion){
        int reproducciones = cancion.getReproducciones();
        int likes = cancion.getLikes();
        int dislikes = cancion.getDislikes();
        if (!cancion.isReproducidaEnLasUltimas24Horas()){
            cancion.setEstado(new EstadoNormal());
            return;
        }
        if (reproducciones > 50000 && likes > 20000){
            cancion.setEstado(new EstadoEnTendencia());
        }
        else if (reproducciones > 1000 && dislikes < 5000){
            cancion.setEstado(new EstadoEnAuge());
        } else {
            cancion.setEstado(new EstadoNormal());
        }
    }
}
