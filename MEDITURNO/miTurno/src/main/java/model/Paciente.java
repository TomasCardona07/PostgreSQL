package model;

public record Paciente(Integer id,String nombre,Integer telefono) {

    public Paciente{
        if (id == null) {
            throw new IllegalArgumentException("El id no debe estar vacio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (telefono == null) {
            throw new IllegalArgumentException("EL telefono no puede estar vacio");
        }
    }

    public Paciente cambiarTelefono(Integer nuevoTelefono){
        return new Paciente(this.id, this.nombre, nuevoTelefono);
    }
}
