public class Categorias {

    private static int reprosParaAuge = 1000;
    private static int reprosParaTendencia = 50000;
    private static int likesParaTendencia = 20000;
    private static int dislikesParaNormal = 5000;
    private static int limiteMinutosSinRepros = 1440; //24 hs sin reproducciones

    public static int getReprosParaAuge() {
        return reprosParaAuge;
    }

    public static int getReprosParaTendencia() {
        return reprosParaTendencia;
    }

    public static int getLikesParaTendencia() {
        return likesParaTendencia;
    }

    public static int getDislikesParaNormal() {
        return dislikesParaNormal;
    }

    public static int getLimiteMinutosSinRepros() {
        return limiteMinutosSinRepros;
    }
}
