/**
 * Created by hassan on 21-May-16.
 */
public class String1 {
    public static void main(String[] args) {
        String message = "Saylani Welfare";
        char ch = 'a';
        int i =  0, count = 0, index;

        while ( i < message.length()) {
            index = message.indexOf(ch, i);
            if(index > -1) {
                count++;
                i = index + 1;
            }
            else {
                break;
            }
        }

        System.out.println(ch + " occurs " + count + " times in \"" + message + "\"");
    }
}
