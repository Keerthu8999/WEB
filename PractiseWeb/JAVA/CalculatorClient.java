import java.rmi.Naming;
public class CalculatorClient{
	public static void main(String[] args) throws Exception{
		Calculator c = (Calculator)Naming.lookup("rmi://localhost/CalcServ");
		c.add(5,3);
	}
}