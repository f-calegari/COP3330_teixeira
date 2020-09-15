import java.util.Arrays;

public class Decrypter {
    String dnumber ="";
    public String decrypt(String inputnumber) {
        int[] numbertodecrypt = new int[4];
        for(int i=0; i<4 ; i++) {
            numbertodecrypt[i] = Character.getNumericValue(inputnumber.charAt(i));
            numbertodecrypt[i] = (numbertodecrypt[i]-7); // reversing Encrypter class, subtracting 7
            if(numbertodecrypt[i]<0)
                numbertodecrypt[i] = numbertodecrypt[i]+10; // and adding 10 if the number is negative
        }
        // Swapping, converting int to string, cleaning up, and returning
        this.dnumber = Arrays.toString(swapDigit(numbertodecrypt));
        this.dnumber = this.dnumber.replaceAll(", ", "").replace("[", "").replace("]", "");
        return (this.dnumber);
    }

    public static int[] swapDigit(int[] numbertodecrypt){
        int position;
        position = numbertodecrypt[0];
        numbertodecrypt[0]=numbertodecrypt[2];
        numbertodecrypt[2]=position;
        position=numbertodecrypt[1];
        numbertodecrypt[1]=numbertodecrypt[3];
        numbertodecrypt[3]=position;
        return numbertodecrypt;
    }
}