package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_1_3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Addition");
        System.out.println("2. Soustraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Votre choix : ");
        int choix = sc.nextInt();

        System.out.print("Entrez a : ");
        double a = sc.nextDouble();
        System.out.print("Entrez b : ");
        double b = sc.nextDouble();

        String ipServeur = "192.168.1.10";
        Socket s = new Socket(ipServeur, 1234);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeInt(choix);
        out.writeDouble(a);
        out.writeDouble(b);

        boolean ok = in.readBoolean();
        if (ok) {
            double resultat = in.readDouble();
            System.out.println("Resultat = " + resultat);
        } else {
            System.out.println("Erreur : division par zéro !");
        }

        s.close();
        sc.close();
    }
}