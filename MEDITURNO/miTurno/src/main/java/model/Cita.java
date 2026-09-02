package model;

public record Cita(Integer id, Paciente idPaciente,String especialidad,String estado,String fecha) {

    public Cita{
        if (id == null) {
            throw new IllegalArgumentException("El id no puede estar vacio");
        }
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacia");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacio");
        }
        if (fecha == null || fecha.isBlank()) {
            throw new IllegalArgumentException("La fecha  no puede estar vacia");
        }
    }
}
