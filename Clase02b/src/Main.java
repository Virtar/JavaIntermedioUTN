
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Que", "tal", "te", "fue");
        Function<String, String> transformarMayusculas = (s) -> s.toUpperCase();
        List<String> resultados = transformarLista(nombres, transformarMayusculas);
        System.out.println(resultados);
    }

    public static List<String> transformarLista(List<String> lista, Function<String, String> funcion) {
        return lista.stream()
                .map(funcion)
                .collect(Collectors.toList());
    }
}
