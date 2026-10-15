package serverPackage;

import java.io.*;
import java.net.*;

public class Server_1_2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Serveur en attente...");

        Socket s = ss.accept();
        System.out.println("Client connecte");

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        int x = in.readInt();
        int resultat = x * 5;
        out.writeInt(resultat);

        s.close();
        ss.close();
    }
}