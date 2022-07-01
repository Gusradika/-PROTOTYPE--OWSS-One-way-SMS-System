import java.util.*;
import java.io.*;

public class prototype_owss {
    public static Scanner sc = new Scanner(System.in);
    public static int pilih, kondisi = 1;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String[] owss = new String[99];
    public static String temp1 = "", temp2 = "", temp3 = "";
    public static Vector storage_pesan = new Vector();

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        do {
            System.out.println(temp3); // Langsung ngeprint pesan di awal secara otomatis. lalu jika ingin membuat
                                       // pesan baru maka clear cache
            System.out.println();
            System.out.println("###############");
            System.out.println("[1] - Kirim Pesan\n[2] - Baca Pesan");
            System.out.print("Masukan inputan >");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    temp3 = ""; // Clear Cahce jangan Lupa!!!!
                    kirim_pesan();
                    break;

                case 2:
                    baca_pesan(); // Unused ATM
                    break;
            }
        } while (true);
    }

    public static void kirim_pesan() throws IOException {
        String pengirim = "Aditya kesuma", roles = "Mahasiswa", penerima = "Gusradika";

        System.out.println("Masukan pesan anda [0 = Stop] [Enter = New Line]: ");
        System.out.println("*****************************************************");
        System.out.println("From: " + pengirim + " - " + roles + "\tTo: " + penerima);
        rekursif_pesan();
    }

    public static void rekursif_pesan() throws IOException {
        String newLine = "\t";
        temp1 = br.readLine();
        temp2 += temp1;

        if (temp1.equalsIgnoreCase("0")) {
            decoder();
        } else {
            rekursif_pesan();
        }
    }

    // Unused ATM
    public static void baca_pesan() throws IOException {
        System.out.println("");
        System.out.println("");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println(storage_pesan.elementAt(0));
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("");
        System.out.println("");
        menu();
    }

    // storage_pesan.add(temp2);
    public static void decoder() throws IOException {
        int a = 50, b = 50;
        for (int i = 0; i < temp2.length(); i++) {
            temp3 += temp2.charAt(i);
            if (i == temp2.length()) {
                storage_pesan.add(temp3);
                menu();
            } else if (i == a) {
                System.out.println(i);
                temp3 += "\n";
                a += b;
            }
        }
    }
}