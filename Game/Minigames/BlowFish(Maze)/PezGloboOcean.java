public class PezGloboOcean {/*Solo  es el main para ejecutar el programa. */
    public static void main (String[] args){
    PezGlobo pez = new PezGlobo("TetraByte",1,"PezGlobo"); /*muestra la informacion del pez globo: Nombre: TetraByte, Especie: Pez Globo, Edad: 1 año  */
    pez.mostrarInfo();
        Juego juego=new Juego ();/*Creo la instancia del jugo */
        juego.iniciar();/* Inicio juego */
    }
}
