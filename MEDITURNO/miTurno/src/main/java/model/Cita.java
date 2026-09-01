package model;

public record Cita(Integer id, Paciente pacienteId,String especialidad,String estado) {

    public Cita{
        if (id == null) {
            throw new IllegalArgumentException("El id no puede estar vacio");
        }
        if (especialidad == null || especialidad.isBlank() ) {
            throw new IllegalArgumentException("La especialidad no puede estar vacio");
        }
        if (estado == null || estado.isBlank() ) {
            throw new IllegalArgumentException("El estado no puede estar vacio");
        }
    }
}