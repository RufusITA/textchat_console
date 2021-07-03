import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {

    public static void main(String[] args) {
      
    	System.out.println("inizializzazione server......");
        ArrayList<ServerThread> threadList = new ArrayList<>();
        try (ServerSocket serversocket = new ServerSocket(5000)){

        	System.out.println("server pronto!");
            while(true) {
                Socket socket = serversocket.accept();

            	System.out.println("Client connesso");
                ServerThread serverThread = new ServerThread(socket, threadList);
                //starting the thread
                threadList.add(serverThread); 
                serverThread.start();

                //get all the list of currently running thread

            }
        } catch (Exception e) {
            System.err.println("Errore");
        }
    }
}