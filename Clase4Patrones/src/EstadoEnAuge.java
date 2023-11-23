public class EstadoEnAuge extends  Estado{
    public EstadoEnAuge()
    {
        this.icono = "Rocket";
        //System.out.println("Estoy en Auge");
    }
    @Override
    public void actuar(ContextoCancion contextoCancion) {

        if(this.cumpleCondicionDeTendencia(contextoCancion))
        {
            contextoCancion.cambiarEstado(new EstadoEnTendencia());
            return;
        }
        if(this.cumpleCondicionDeNormal(contextoCancion))
        {
            contextoCancion.cambiarEstado(new EstadoNormal());
        }
    }

    @Override
    public void escribirLeyenda(ContextoCancion contextoCancion) {
        this.leyenda = contextoCancion.getArtista() + " - " + contextoCancion.getNombreCancion() + " ( "+ contextoCancion.getAlbum() + " - " + contextoCancion.getAnio() + " )" ;
        super.escribirLeyenda(contextoCancion);
    }
}
