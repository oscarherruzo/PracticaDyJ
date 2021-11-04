
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;



public class EnlaceURL {

	public static void main(String[] args) throws MalformedURLException, IOException {
	
		Scanner sc = new Scanner (System.in);
		
		String url="";
		String nombre , archivo_destino;
		
		String destino_descargas="json/";
		int ciudades;
		File directorio = new File(destino_descargas);
		
		if(!directorio.exists())
			if(!directorio.mkdir())
				return;
		
		
		Properties configuracion = new Properties();   
		
		System.out.println("Indique la cantidad de ciudades a introducir");
		ciudades=sc.nextInt();
		
		for(int i=1;i<=ciudades;i++) {
			
			System.out.println("Indique el nombre de la " + i + " ciudad");
			nombre=sc.next();
		
			      
			configuracion.load(new FileReader("src/config.properties"));        
			Set<String> ciudadess = configuracion.stringPropertyNames();
			
			String fichero = configuracion.getProperty(nombre);
			
			
		File file = new File(destino_descargas + nombre + ".json");
		
		URLConnection conn = new URL(url).openConnection();
		conn.connect();
		System.out.println("\nempezando descarga: \n");
		System.out.println(">> URL: " + url);
		System.out.println(">> Nombre: " + nombre);
		System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");

		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(file);
		
		
		int bytes = 0;
		
		while (bytes!=-1) {
			bytes=in.read();
			if(bytes!=-1) {
				out.write(bytes);
			}
		}
		
		}
	}

}
