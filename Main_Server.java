import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            RemoteImpl obj = new RemoteImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteInterface", obj);
            System.out.println("Servidor pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
