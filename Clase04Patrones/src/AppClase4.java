public class AppClase4 {

    public static void main(String args[])
    {
        //instancio hit de Coldplay
        ContextoCancion scientistColdplay = new ContextoCancion("The Scientist", "Coldplay", "A rush of blood to the head", 2002);

        //se inicia en modo normal por defecto
        scientistColdplay.mostrarInfo();

        //actuar es chequear condiciones de cambio --refactorizar nombre¿?
        scientistColdplay.actuar(); //chequea condiciones de cambio, sigue en estado normal

        //seteo para que cambie a estado en auge
        scientistColdplay.setReproducciones(1001);

        //vuelvo a pedirle que actue. Este actuar cambia el estado a "en auge"
        scientistColdplay.actuar();
        scientistColdplay.mostrarInfo();

        //ahora seteo dislikes para que vuelva a normal
        scientistColdplay.setDislikes(5001);

        scientistColdplay.actuar();
        scientistColdplay.mostrarInfo();

        //ahora seteo para que pase directamente de normal a tendencia
        scientistColdplay.setLikes(21000);
        scientistColdplay.setReproducciones(51000);

        scientistColdplay.actuar();
        scientistColdplay.mostrarInfo();

        //lamentablemente ya nadie escucha la cancion y vuelve a normal
        scientistColdplay.setUltimaReproEnMins(1441);

        scientistColdplay.actuar();
        scientistColdplay.mostrarInfo();
    }
}
