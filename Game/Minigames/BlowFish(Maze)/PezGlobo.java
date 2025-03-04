public class PezGlobo { /* Define el pez y permite mostrar su información */
    public String nombre;/*se accede desde culaquier parte  */
    private int edad; /*se accede dentro de la clase */
    private String especie;

    public PezGlobo (String nombre, int edad, String especie){
        this.nombre =nombre;
        this.edad=edad;
        this.especie=especie;
        
    }
    public void mostrarInfo(){
        System.out.println("Nombre:"+ nombre +", Especie:"+ especie +",Edad:"+ edad +"año");
        mostrarEdad();
    }
}