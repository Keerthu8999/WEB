import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class MultiServer{
	public static void main(String[] args)throws Exception{
		InetAddress iadd = InetAddress.getByName("224.0.0.3");
		try(DatagramSocket ds = new DatagramSocket()){
			for(int i=0;i<5;i++){
				String msg = "HELLO" + i;
				DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,iadd,2222);
				ds.send(dp);
				System.out.println(msg);
			}
		}
		catch(Exception e){e.printStackTrace();}
	}
}