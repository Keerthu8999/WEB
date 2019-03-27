import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class Server{
	public static void main(String[] args)throws Exception{
		InetAddress iadd = InetAddress.getByName("127.0.0.1");
		byte[] receive = new byte[65535];
		DatagramSocket ds = new DatagramSocket(1234);
		while(true){
			DatagramPacket dp = new DatagramPacket(receive,receive.length);
			ds.receive(dp);
			System.out.println(data(receive));
			receive = new byte[65535];
		}
	}
	public static StringBuilder data(byte[] a){
		if(a == null){return null;}
		int i = 0;
		StringBuilder ret = new StringBuilder();
		while(a[i]!=0){
			ret.append((char)a[i]);
			i++;
		}
		return ret;
	}
}