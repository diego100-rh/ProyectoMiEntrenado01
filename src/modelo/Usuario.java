package modelo;

public class Usuario {
    private String nombre;
    private String matricula;
    private String contraseña;
    // DATOS OBLIGATORIOS PA CREAR UN REGISTRO

    private int edad;
    private double peso;
    private String genero; //F O M
    private TestFisico.Nivel nivel; //  resultado del test físico

    // DATOS OBLIGATORISO DEL TEST

    public Usuario(String nombre, String matricula, String contraseña) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.contraseña = contraseña;

    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getContraseña() {
        return contraseña;
    }

    // Setters y Getters para los datos del test
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }


    public TestFisico.Nivel getNivel() { return nivel; }
    public void setNivel(TestFisico.Nivel nivel) { this.nivel = nivel; }

}