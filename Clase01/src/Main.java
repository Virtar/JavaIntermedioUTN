import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Construyo Materia (creando antes una lista con sus correlativas)

        List<Materia> correlativasmat1 = new ArrayList();
        Materia mat1 = new Materia("Algoritmos y Estructuras de Datos", correlativasmat1);

        List<Materia> correlativasmat2 = new ArrayList();
        correlativasmat2.add(mat1);
        Materia mat2 = new Materia("Paradigmas de Programación", correlativasmat2 );

        List<Materia> correlativasmat3 = new ArrayList();
        correlativasmat3.add(mat1);
        correlativasmat3.add(mat2);
        Materia mat3 = new Materia("Diseño de Sistemas", correlativasmat3);

        // Construyo Alumno (creando antes una lista con sus materias aprobadas)
        List<Materia> mataprobadas = new ArrayList();
        mataprobadas.add(mat1);
        mataprobadas.add(mat2);
        Alumno alumno = new Alumno("Pedro", "Solis", mataprobadas);


        Inscripcion inscripcion = new Inscripcion(alumno, mat3);

        System.out.println(inscripcion.inscripcionValida());




    }
}