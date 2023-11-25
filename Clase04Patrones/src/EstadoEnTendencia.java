public class EstadoEnTendencia extends Estado{

    public EstadoEnTendencia()
    {
        this.icono = "Fire";
        //System.out.println("Estoy en Tendencia");
    }
    @Override
    public void actuar(ContextoCancion contextoCancion) {

        if(this.cumpleCondicionDeNormal(contextoCancion))
        {
            contextoCancion.cambiarEstado(new EstadoNormal());
        }
    }

    @Override
    public void escribirLeyenda(ContextoCancion contextoCancion) {
        this.leyenda = contextoCancion.getNombreCancion() + " - " + contextoCancion.getArtista() + " ( "+ contextoCancion.getAlbum() + " - " + contextoCancion.getAnio() + " )" ;
        super.escribirLeyenda(contextoCancion);
    }
}
