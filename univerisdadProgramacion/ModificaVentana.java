package univerisdadProgramacion;

public interface ModificaVentana { //las clases que lo implementen podran modificar la ventana principal

	public void setOnTop(Marcos miMarco,boolean alwaysOnTop); //Para que este por encima del resto
	public void repaintVentana(Marcos miMarco); //Para cambiar el texto del marco si no funciona el metodo de la clase Textos
}
