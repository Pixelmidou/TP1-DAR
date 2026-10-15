package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client_1_2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tapez un entier x : ");
        int x = sc.nextInt();

        Socket s = new Socket("localhost", 1234);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeInt(x);

        int resultat = in.readInt();
        System.out.println("x * 5 = " + resultat);

        s.close();
        sc.close();
    }
}