import java.util.ArrayList;
import java.util.List;

public class Cadena implements CambiarString{

    @Override
    public String pasarAMayusculas(String string) {
        return string.toUpperCase();
    }


    public List<String> transformarListado(List<String> lista) {
        List<String> listaTransformada = new ArrayList<>();
        for (String string : lista) {
            listaTransformada.add(pasarAMayusculas(string));
        }
        return listaTransformada;
    }
}
