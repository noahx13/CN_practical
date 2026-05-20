import java.util.Scanner;

public class CRC {

    static int xor(int a, int b) {
        return a == b ? 0 : 1;
    }

    static int[] divide(int data[], int divisor[]) {

        int rem[] = new int[divisor.length];

        System.arraycopy(data, 0, rem, 0, divisor.length);

        for (int i = 0; i < data.length - divisor.length + 1; i++) {

            if (rem[0] == 1) {

                for (int j = 1; j < divisor.length; j++)
                    rem[j - 1] = xor(rem[j], divisor[j]);

            } else {

                for (int j = 1; j < divisor.length; j++)
                    rem[j - 1] = xor(rem[j], 0);
            }

            if (i + divisor.length < data.length)
                rem[divisor.length - 1] = data[i + divisor.length];
        }

        return rem;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, m;

        System.out.print("Enter data size: ");
        n = sc.nextInt();

        int data[] = new int[n];

        System.out.println("Enter data bits:");

        for (int i = 0; i < n; i++)
            data[i] = sc.nextInt();

        System.out.print("Enter divisor size: ");
        m = sc.nextInt();

        int divisor[] = new int[m];

        System.out.println("Enter divisor bits:");

        for (int i = 0; i < m; i++)
            divisor[i] = sc.nextInt();

        int appended[] = new int[n + m - 1];

        for (int i = 0; i < n; i++)
            appended[i] = data[i];

        int rem[] = divide(appended, divisor);

        System.out.print("CRC Code: ");

        for (int i = 0; i < n; i++)
            System.out.print(data[i]);

        for (int i = 0; i < m - 1; i++)
            System.out.print(rem[i]);
    }
}