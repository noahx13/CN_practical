import java.util.Scanner;

public class HammingCode {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int data[] = new int[7];
        int rec[] = new int[7];

        int c1, c2, c3, c;

        System.out.println("Works for 4-bit message");
        System.out.println("Enter 4 message bits:");

        // Enter data bits
        sc.nextInt();
        data[0] = sc.nextInt();
        data[1] = sc.nextInt();
        data[2] = sc.nextInt();
        data[4] = sc.nextInt();

        // Calculate parity bits
        data[6] = data[0] ^ data[2] ^ data[4];
        data[5] = data[0] ^ data[1] ^ data[4];
        data[3] = data[0] ^ data[1] ^ data[2];

        // Display encoded bits
        System.out.println("Encoded bits are:");

        for(int i = 0; i < 7; i++) {
            System.out.print(data[i] + " ");
        }

        // Receive bits
        System.out.println("\nEnter received 7 bits:");

        for(int i = 0; i < 7; i++) {
            rec[i] = sc.nextInt();
        }

        // Check parity
        c1 = rec[6] ^ rec[4] ^ rec[2] ^ rec[0];
        c2 = rec[5] ^ rec[4] ^ rec[1] ^ rec[0];
        c3 = rec[3] ^ rec[2] ^ rec[1] ^ rec[0];

        c = c3 * 4 + c2 * 2 + c1;

        // Error checking
        if(c == 0) {

            System.out.println("No error found");

        } else {

            System.out.println("Error at position: " + c);

            // Correct error
            if(rec[7 - c] == 0)
                rec[7 - c] = 1;
            else
                rec[7 - c] = 0;

            System.out.println("Corrected code:");

            for(int i = 0; i < 7; i++) {
                System.out.print(rec[i] + " ");
            }
        }
    }
}