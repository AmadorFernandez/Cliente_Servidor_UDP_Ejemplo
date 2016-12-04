import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {
	public static final int PuertoServidor = 5555;
	public static final int PuertoCliente = 5556;
	public static final String IPServidor = "localhost";
	
	public ClienteUDP() {
		DatagramSocket emisor;
		DatagramPacket dgp;
		InetAddress localIP;
		InetAddress remoteIP;
		
		try {
			
			String mensaje  = "illo";
			byte[] dato = mensaje.getBytes(); 
			
			localIP = InetAddress.getByName("0.0.0.0");
			remoteIP = InetAddress.getByName(IPServidor);
			
			emisor = new DatagramSocket(PuertoCliente, localIP);
			
			
			dgp = new DatagramPacket(dato, dato.length, remoteIP, PuertoServidor);
			
		
			emisor.send(dgp);
			System.out.println("Datos enviados");
			
			emisor.close();
			
		} catch (SocketException | UnknownHostException e) {
			System.out.println("Problema al crear el socket");
		} catch (IOException e) {
			System.out.println("Problema al recibir el datagrama");
		}
	}

	public static void main(String[] args) {
		new ClienteUDP();
	}

}
