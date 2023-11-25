import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<String> listado = Arrays.asList("que", "tal","te","fue");
        listado.replaceAll(str -> str.toUpperCase());
        System.out.print (listado);

    }
//Se puede utilizar for each o map


}