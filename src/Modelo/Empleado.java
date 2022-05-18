package Modelo;

public class Empleado {
    
    private int id_empleado;
    private String nombre;
    private String dni;
    private String usuario;
    private String contraseña;
    private String celular;
    private String rol;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombre, String dni, String usuario, String contraseña, String celular, String rol) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.dni = dni;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.celular = celular;
        this.rol = rol;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
    
}
