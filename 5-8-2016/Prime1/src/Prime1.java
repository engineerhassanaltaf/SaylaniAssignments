import java.util.Scanner;

/**
 * Created by hassan on 11-May-16.
 */
public class Prime1 {
    private static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean isPrime = true;

        System.out.print("Enter the range (e.g 50-100): ");
        String range = sc.nextLine();

        int min = Integer.parseInt(range.substring(0,range.indexOf("-")));
        int maximum = Integer.parseInt(range.substring(range.indexOf("-")+1,range.length()));
        int minimum = min;

        System.out.print("Enter the max count of prime numbers: ");
        int count = sc.nextInt();

        int[] primeNumbers = new int[count];

        while (min < maximum) {
            for (int j = 2; j < min; j++) {
                if(min%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                if(n == count) {
                    break;
                }
                primeNumbers[n++] = min;

            }
            isPrime = true;
            min++;
        }

        System.out.println(count + " Prime number(s) between " + minimum + " and " + maximum + " are:");
        for(int x: primeNumbers) {
            System.out.print(x + "\t");
        }

    }
}
