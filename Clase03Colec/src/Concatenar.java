import java.util.ArrayList;
import java.util.List;

public class Concatenar {


    public List<String> concatenar(List<String> lista, int n){
        List <String> listado = new ArrayList<>();
        for(String s:lista){
            if(s.length()>n){
                listado.add(s);
            }
        }
        return listado;

    }

}
