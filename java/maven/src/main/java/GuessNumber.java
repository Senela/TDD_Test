/**
 * Created by Senela on 15-1-31.
 */
public class GuessNumber {
    private String randomNumber;

    public String getTips(String input, String answer) {
        int length = input.length();
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < length; i++){

            if (input.charAt(i) == answer.charAt(i)) {
                aCount++;
            } else if (input.contains(answer.subSequence(i,i + 1))){
                System.out.print(answer.subSequence(i,i));
                bCount++;
            }
        }
        return aCount + "A" + bCount + "B";
    }


}
