package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {

	//MODIFICABLES
	private String ip = "127.0.0.1";
	private int puertoServer=6666;
	String chat=" ";
	
	
	Cliente()
	{
		
		try {
			
			//creo el socket para el chat
			Socket sConexcionActual=new Socket(InetAddress.getByName(ip), puertoServer);

		    
		    InputStream IN = sConexcionActual.getInputStream();
		    OutputStream OUT = sConexcionActual.getOutputStream();
		    
		    PrintWriter outputString = new PrintWriter(new OutputStreamWriter(OUT));
		    BufferedReader inputString = new BufferedReader(new InputStreamReader(IN));
		    
		    
		    
		    while(!chat.equalsIgnoreCase("chau"))
			 {
		    	//escribo mensaje
				chat=JOptionPane.showInputDialog("Ingrese su mensaje, 'chau' para finalizar");
				 
				//muestro en consola el mensaje
				System.out.println("Usted dice:"+chat);
				
				//preparo el mensaje
				outputString.println(chat);
				
				//envio el mensaje
				outputString.flush();
				
				//espero respuesta
				System.out.println(sConexcionActual.getInetAddress() + ":" + sConexcionActual.getPort() +" dice: "+ inputString.readLine());
				
				
			 }
		    
		    
		    //cierro socket
			sConexcionActual.close();
			
			System.out.println("fin cliente");
		} 
		
		catch (UnknownHostException e)
		
		
		{
		e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
