package RMIInterface;
import java.rmi.*;
import java.rmi.RemoteException;
import java.util.List;
import Boo.Book;
public interface RMIInterface extends Remote {

    Book findBook(Book b) throws RemoteException;
    List<Book> allBooks() throws RemoteException;

}