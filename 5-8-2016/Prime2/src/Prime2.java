
/**
 * Created by hassan on 12-May-16.
 */
public class Prime2 {
    private static int[] numbers = new int[50];
    private static boolean isPrime = true;

    public static void main(String[] args) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math. random() * 500 + 1);
        }
        System.out.println("Numbers: ");
        for(int x: numbers) {
            System.out.print(x + "\t");
        }
        System.out.println("\nAmoung these, prime numbers are:");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 2; j < numbers[i]; j++) {
                if(numbers[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                System.out.print(numbers[i] + "\t");
            }
            isPrime = true;
        }
    }
}
