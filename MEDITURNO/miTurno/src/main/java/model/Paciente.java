package model;

public record Paciente(Integer id, String nombre,String telefono) {

    public Paciente{
        if (id == null) {
            throw new IllegalArgumentException("El id no puede estar vacio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El telefono no puede estar vacio");
        }
    }
    
    public Paciente cambiarTelefono(String nuevoTel){
        return new Paciente(this.id, this.nombre, nuevoTel);
    }
}