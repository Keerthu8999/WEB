import java.rmi.Naming;
import java.io.*;
public class CalculatorServer{
	public CalculatorServer(){
		Calculator c = new CalculatorImpl();
		Naming.rebind("rmi://localhost/CalcServ",c);
	}
	public static void main(String[] args) throws RemoteException{
		new CalculatorServer();
	}
}