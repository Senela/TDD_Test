/**
 * Created by myqu on 15/2/10.
 */
public class AnswerGenerator {

    public String getRandomNumber() {

        int index = 0;
        String randomNumber;

        do {

            randomNumber =String.valueOf( (int)(Math.random()*9000+1000) );
            System.out.println("RandomNumber：" + randomNumber);

            for(int i=0; i< randomNumber.length(); i++)
            {
                String compareString = randomNumber.substring(i, i+1);
                String subString = randomNumber.substring(0, i) + randomNumber.substring(i+1, randomNumber.length());
                index = subString.indexOf(compareString);
                if(index != -1)
                    break;
            }

        }while (index != -1);

        return randomNumber;
    }
}
