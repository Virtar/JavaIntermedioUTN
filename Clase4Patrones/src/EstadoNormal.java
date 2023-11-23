public class EstadoNormal extends Estado {

    public EstadoNormal()
    {
        this.icono = "Musical Note";
        //System.out.println("En Modo Normal");
    }

    @Override
    public void actuar(ContextoCancion contextoCancion) {

        if(this.cumpleCondicionDeTendencia(contextoCancion))
        {
            contextoCancion.cambiarEstado(new EstadoEnTendencia());
            return;
        }

        if(this.cumpleCondicionDeAuge(contextoCancion))
        {
            contextoCancion.cambiarEstado(new EstadoEnAuge());
        }
    }

    @Override
    public void escribirLeyenda(ContextoCancion contextoCancion)
    {
        this.leyenda = contextoCancion.getArtista() + " - " + contextoCancion.getAlbum() + " - " + contextoCancion.getNombreCancion();
        super.escribirLeyenda(contextoCancion); //llamo a los souts que estan en la clase madre
    }

}
