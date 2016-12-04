import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServidorUDP {
	public static final int PuertoServidor = 5555;
	public static final String IPServidor = "0.0.0.0";
	
	public ServidorUDP() {
		try {
			
			DatagramSocket socket = new DatagramSocket(PuertoServidor, InetAddress.getByName(IPServidor));
			
		
			DatagramPacket dato = new DatagramPacket(new byte[255], 255);
			System.out.println("Servidor atendiendo al socket: " +  socket.getLocalAddress());
			
			while (true) {
				socket.receive(dato); 
				System.out.println("Dato recibido de " + dato.getAddress().getHostName() + " -> ");
			
				String mensaje = new String(dato.getData(), dato.getOffset(), dato.getLength());
				System.out.println(" // de longitud: " + mensaje.length());
				System.out.println(mensaje);
				mensaje = null;
			}
		} catch (SocketException | UnknownHostException e) {
			System.out.println("Problema al crear el socket");
		} catch (IOException e) {
			System.out.println("Problema al recibir el datagrama");
		}
	}

	public static void main(String[] args) {
		new ServidorUDP();
	}

}
