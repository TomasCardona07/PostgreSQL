package model;
import java.math.BigDecimal;
public class Videojuego {
    private int id;
    private String nombre;
    private String genero;
    private BigDecimal precio;
    private int cantidad;

    public Videojuego(int id, String nombre,String genero,BigDecimal precio,int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId(){return this.id;}
    public String getNombre(){return this.nombre;}
    public String getGenero(){return this.genero;}
    public BigDecimal getPrecio(){return this.precio;}
    public int getCantidad(){return this.cantidad;}

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
        public void setGenero(String genero){
        this.genero = genero;
    }
        public void setPrecio(BigDecimal precio){
        this.precio = precio;
    }
        public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
}