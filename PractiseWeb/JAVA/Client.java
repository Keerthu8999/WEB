import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class Client{
	public static void main(String[] args)throws Exception{
		InetAddress iadd = InetAddress.getByName("127.0.0.1");
		DatagramSocket ds = new DatagramSocket();
		byte[] buf = new byte[65536];
		Scanner sc = new Scanner(System.in);
		while(true){
			String inp = sc.nextLine();
			buf = inp.getBytes();
			DatagramPacket dp = new DatagramPacket(buf,buf.length,iadd,1234);
			ds.send(dp);
	}}}
