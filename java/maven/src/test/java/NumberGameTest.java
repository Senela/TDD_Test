import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.verification.VerificationMode;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Senela on 15-2-6.
 */
public class NumberGameTest {

    @Test
    public  void  should_input_number_length_is_four()
    {
        NumberGame numberGame = new NumberGame(new GuessNumber(), new GenerateRandomNumber(new Random()));

        assert(numberGame.checkInputNumberLengthIsFour("1234"));
        assert(!numberGame.checkInputNumberLengthIsFour("124"));
    }

    @Test
    public  void  should_input_number_is_digits()
    {
        NumberGame numberGame = new NumberGame(new GuessNumber(), new GenerateRandomNumber(new Random()));

        assert(numberGame.checkInputNumberIsAllDigit("1234"));
        assert(!numberGame.checkInputNumberIsAllDigit("1AD4"));
    }

    @Test
    public  void  should_input_number_has_no_duplicate()
    {
        NumberGame numberGame = new NumberGame(new GuessNumber(), new GenerateRandomNumber(new Random()));

        assertThat(numberGame.checkInputNumberLengthIsFour("1234")).isEqualTo(true);
        assert(numberGame.checkInputNumberHasNoDuplicate("1234"));
        assert(!numberGame.checkInputNumberHasNoDuplicate("1224"));
    }


    @Test
    public  void  start_with_welcome_info()
    {
        GenerateRandomNumber generateRandomNumber = mock(GenerateRandomNumber.class);
        when(generateRandomNumber.getRandomNumber()).thenReturn("1234");

        PrintStream print = new PrintStream(System.out);


        GuessNumber guessNumber = new GuessNumber();
        GenerateRandomNumber generateRandomNumber1 = new GenerateRandomNumber(new Random());
        NumberGame numberGame = new NumberGame(guessNumber, generateRandomNumber);

        numberGame.StartPlayGame(new Scanner(System.in));

    }


}
