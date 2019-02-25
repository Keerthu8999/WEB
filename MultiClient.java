import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class MultiClient{
	public static void main(String[] args)throws Exception{
		InetAddress iadd = InetAddress.getByName("224.0.0.3");
		byte[] buf = new byte[256];
		try(MulticastSocket sock = new MulticastSocket(2222)){
			sock.joinGroup(iadd);
			while(true){
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				sock.receive(dp);
				String msg = new String(buf,0,buf.length);
				System.out.println(msg);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}