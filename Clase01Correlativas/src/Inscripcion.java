public class Inscripcion {

    private Alumno alumno;
    private Materia materia;

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public boolean inscripcionValida() {

        if (materia.getCorrelativas().isEmpty()) {
            return true;
        } else if (!materia.getCorrelativas().isEmpty() & alumno.getMateriasAprobadas().isEmpty()) {
            return false;
        } else {
            int ncorrelativas = materia.getCorrelativas().size();
            int ncorrelativasapro = 0;
            for (Materia m : materia.getCorrelativas()) {
                for (Materia a : alumno.getMateriasAprobadas()) {
                    if (a.getNombre().equals(m.getNombre())) {
                        ncorrelativasapro++;
                        if (ncorrelativasapro == ncorrelativas) {
                            return true;
                        }
                    }
                }
            }
        }
    return false;
    }

}


