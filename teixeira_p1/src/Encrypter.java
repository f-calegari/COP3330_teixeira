import java.util.Arrays;

public class Encrypter {
    String enumber ="";
    public String encrypt(String inputnumber) {
        int[] numbertoencrypt = new int[4];
        for(int i=0; i<4 ; i++) {
            numbertoencrypt[i] = Character.getNumericValue(inputnumber.charAt(i));
            numbertoencrypt[i] = (numbertoencrypt[i]+7)%10; // encrypt = result of adding 7 and getting mod 10
        }
        // Swapping, converting int to string, cleaning up, and returning
        this.enumber = Arrays.toString(swapDigit(numbertoencrypt));
        this.enumber = this.enumber.replaceAll(", ", "").replace("[", "").replace("]", "");
        return (this.enumber);
    }

    public static int[] swapDigit(int[] numbertoencrypt){
        int position;
        position = numbertoencrypt[0];
        numbertoencrypt[0]=numbertoencrypt[2];
        numbertoencrypt[2]=position;
        position=numbertoencrypt[1];
        numbertoencrypt[1]=numbertoencrypt[3];
        numbertoencrypt[3]=position;
        return numbertoencrypt;
    }
}