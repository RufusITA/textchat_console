import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)){
         
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

            
            Scanner scanner = new Scanner(System.in);
            String userInput;
            String response;
            String clientName = "empty";

            ClientRunnable clientRun = new ClientRunnable(socket);


            new Thread(clientRun).start();
           
           
           do {
               
               if (clientName.equals("empty")) {
                    System.out.println("inserisci il tuo NickName : ");
                    userInput = scanner.nextLine();
                    clientName = userInput;
                   // output.println(userInput);
                    if (userInput.equals("exit")) {
                        break;
                    }
               } 
               else {
                    String message = ( "(" + clientName + ")" + " scrive : " );
                 //   System.out.println(message);
                    userInput = scanner.nextLine();
                    output.println(message + " " + userInput);
                    if (userInput.equals("exit")) {
                        //reading the input from server
                        break;
                    }
                }

           } while (!userInput.equals("exit"));
           


            
        } catch (Exception e) {
            System.err.println("Errore  ");
    }
    }
}