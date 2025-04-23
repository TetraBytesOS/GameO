package univerisdadProgramacion;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Imagenes {

	static Image miFoto=null;
	
	public static void setImagen(String ruta) {
		File miArchivo=new File(ruta);
		try {
			miFoto=ImageIO.read(miArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Imagen no encontrada");
		}
	}
	
	public static Image getImagen() {
		return miFoto;
	}
}
