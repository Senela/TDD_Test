import java.util.Random;
import java.util.Scanner;

import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by Senela on 15-2-6.
 */
public class NumberGame {


    private final GuessNumber guessNumber;
    private final GenerateRandomNumber generateRandomNumber;

    public NumberGame(GuessNumber guessNumber, GenerateRandomNumber  generateRandomNumber) {

        this.guessNumber = guessNumber;
        this.generateRandomNumber = generateRandomNumber;
    }

    public  void  StartPlayGame(Scanner scanner)
    {
        System.out.println("Welcome!\n");
        String random = generateRandomNumber.getRandomNumber();

        int count = 6;
        while (count >0)
        {
            System.out.println("Please input your number("+ count +"):" );
            String inputNumber = scanner.nextLine();

            boolean legal = CheckLegalNumber(inputNumber);

            if(legal) {
                count--;
                showResult(guessNumber.getTips(inputNumber, random), count);
            }

        }

        System.out.println("Game Over!");

    }

    public void showResult(String result, int times)
    {
        if(result.equals("4A0B")) {
            System.out.println("Congratulations!");
        }
        else
            System.out.println(result);
    }

    public boolean CheckLegalNumber(String inputNumber)
    {
        if(!checkInputNumberIsAllDigit(inputNumber) || !checkInputNumberLengthIsFour(inputNumber)) {
            System.out.println("Cannot input illegal numbers!");
            return false;
        }
        else  if(!checkInputNumberHasNoDuplicate(inputNumber)) {
            System.out.println("Cannot input duplicate numbers!");
            return  false;
        }
        return  true;
    }

    public boolean checkInputNumberLengthIsFour(String inputNumber)
    {
        if(inputNumber.length()!= 4){
            return false;
        }
        return  true;
    }

    public boolean checkInputNumberIsAllDigit(String inputNumber)
    {
        try {
            Integer.parseInt(inputNumber);
        }catch (NumberFormatException e) {
            System.out.println("Cannot input illegal numbers!");
            return false;
        }

        return  true;
    }

    public boolean checkInputNumberHasNoDuplicate(String inputNumber)
    {
        for(int i=0; i< inputNumber.length(); i++)
        {
            char oneChar = inputNumber.charAt(i);
            if(inputNumber.indexOf(oneChar) != inputNumber.lastIndexOf(oneChar))
            {
                return false;
            }
        }

        return true;
    }

    public static  void  main(String[] args) {

        GuessNumber guessNumber1 = new GuessNumber();
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber(new Random());

        NumberGame numberGame = new NumberGame(guessNumber1, generateRandomNumber);
        numberGame.StartPlayGame(new Scanner(System.in));
    }


}
