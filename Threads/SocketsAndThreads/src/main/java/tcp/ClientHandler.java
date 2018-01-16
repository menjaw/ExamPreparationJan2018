/*
 * Denne klasse extender threads og der oprettes en instans/task af denne klasse hver gang en ny client logger på serveren
 * ClientHandler lytter efter input fra client 
 */
package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class ClientHandler extends Thread {

    //Variabler
    Socket socketConnection; //Socket skaber forbindelse mellem server og client
    TcpServer masterServer;
    Scanner inputFromClient; //Message from client
    PrintWriter messageToClient;//Bruges i forbindelse med at der skal komme svar tilbage til client

    //Constructor
    public ClientHandler(Socket socketConnection, TcpServer masterServer) throws IOException {
        //
        this.socketConnection = socketConnection;
        this.masterServer = masterServer;

        //
        inputFromClient = new Scanner(socketConnection.getInputStream());//getInpuStream returner input fra socket
    }

    //Kør tråde
    @Override
    public void run() {

        System.out.println("Tråden er startet");
        this.masterServer.addClientToServer(this);//this referer til clienHandler

        String messageFromClient = inputFromClient.nextLine();//blokerende kald og venter 1 gang

        while (!messageFromClient.toUpperCase().equals("EXIT")) {
            System.out.println("Hey dette er fra Client: " + messageFromClient);
            messageFromClient = inputFromClient.nextLine();//sørger for at vente på næste input
        }

        try {
            this.masterServer.removeClientFromServer(this);
            socketConnection.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
