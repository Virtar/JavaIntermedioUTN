import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> lista1 = Arrays.asList("Que", "tal", "te", "fue");

        Concatenar concatt = new Concatenar();

        System.out.println(concatt.concatenar(lista1, 2));

    }
}