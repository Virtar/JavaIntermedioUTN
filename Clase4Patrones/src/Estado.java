public abstract class Estado {

    protected String icono;
    protected String leyenda;

    public abstract void actuar(ContextoCancion contextoCancion);

    public void escribirLeyenda(ContextoCancion contextoCancion)
    {
        System.out.println(this.icono);
        System.out.println(this.leyenda);
    }

    protected boolean cumpleCondicionDeNormal(ContextoCancion contextoCancion)
    {
        return contextoCancion.getDislikes()>=Categorias.getDislikesParaNormal();
    }

    protected boolean cumpleCondicionDeAuge(ContextoCancion contextoCancion)
    {
        return contextoCancion.getReproducciones() > Categorias.getReprosParaAuge();
    }

    protected boolean cumpleCondicionDeTendencia(ContextoCancion contextoCancion)
    {
        return (contextoCancion.getReproducciones()>Categorias.getReprosParaTendencia())&&(contextoCancion.getLikes()>Categorias.getLikesParaTendencia());
    }
}
