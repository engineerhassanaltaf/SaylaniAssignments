/**
 * Created by hassan on 21-May-16.
 */
public class String2 {
    public static void main(String[] args) {
        String ones[] = {"one","two","three","four","five","six","seven","eight","nine"};
        String elevenToNinteen[] = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
        String tens[] = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety",};
        int nums[] = {6, 10, 95, 26, 20, 15, 19, 80, 35};

        for(int n : nums) {
            if(n >= 1 && n <= 9 ) {
                System.out.println(n + " => " + ones[n-1]);
            }
            else if(n >= 11 && n <= 19 ) {
                System.out.println(n + " => " + elevenToNinteen[n-11]);
            }
            else if (n%10 == 0) {
                System.out.println(n + " => " + tens[n/10-1]);
            }
            else {
                System.out.println(n + " => " + tens[n/10-1] + " " + ones[n%10-1]);
            }
        }
    }
}
