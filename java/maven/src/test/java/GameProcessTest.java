import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by myqu on 15/2/10.
 */
public class GameProcessTest {

    private PrintStream out;
    private  GameProcess gameProcess;
    private   BufferedReader bufferedReader;
    private  GuessNumber    guessNumber;
    private  InOrder  inOrder;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);

        bufferedReader = mock(BufferedReader.class);
        guessNumber = new GuessNumber();

        inOrder = inOrder(out);

        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);

        when(answerGenerator.getRandomNumber()).thenReturn("4321");

        when(bufferedReader.readLine()).thenReturn("1234");
        when(bufferedReader.readLine()).thenReturn("1234");
        when(bufferedReader.readLine()).thenReturn("1234");
        when(bufferedReader.readLine()).thenReturn("1234");
        when(bufferedReader.readLine()).thenReturn("1234");
        when(bufferedReader.readLine()).thenReturn("1234");

        gameProcess = new GameProcess(out, bufferedReader, guessNumber, answerGenerator);
    }

    @Test
    public void  should_print_welcome_when_game_start() throws IOException {
        verify(out, never()).println("Welcome!");
        gameProcess.start();
        verify(out).println("Welcome!");

    }

    @Test
    public void should_print_please_input_after_game_start() throws IOException {
        gameProcess.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
    }


    @Test
    public void should_reduce_one_change_when_guess_wrong() throws IOException {

        gameProcess.start();

        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5):");
    }


    @Test
    public void should_reduce_one_by_one_until_game_over() throws IOException {


        gameProcess.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your number(1):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Game over!");
    }




}
