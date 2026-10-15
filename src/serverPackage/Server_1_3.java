package serverPackage;

import java.io.*;
import java.net.*;

public class Server_1_3 {
    public static void main(String[] args) throws IOException {
        int port = 1234;

        ServerSocket ss = new ServerSocket();
        // 0.0.0.0 : ecoute en tous les interfaces réseau du pc
        ss.bind(new InetSocketAddress("0.0.0.0", port));

        System.out.println("Serveur en attente sur le port " + port);

        Socket s = ss.accept();
        System.out.println("Client connecté");

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        int choix = in.readInt();
        double a = in.readDouble();
        double b = in.readDouble();

        boolean ok = true;
        double resultat = 0;
        switch (choix) {
            case 1: resultat = a + b; break;
            case 2: resultat = a - b; break;
            case 3: resultat = a * b; break;
            case 4:
                if (b == 0) ok = false;
                else resultat = a / b;
                break;
            default: ok = false;
        }

        out.writeBoolean(ok);
        if (ok) out.writeDouble(resultat);

        s.close();
        ss.close();
    }
}