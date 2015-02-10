import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by myqu on 15/2/10.
 */
public class GameProcess {
    private PrintStream out;
    private BufferedReader bufferedReader;
    private GuessNumber guessNumber;
    private AnswerGenerator answerGenerator;


    public GameProcess(PrintStream out, BufferedReader bufferedReader, GuessNumber guessNumber, AnswerGenerator answerGenerator) {
        this.out = out;

        this.bufferedReader = bufferedReader;
        this.guessNumber = guessNumber;
        this.answerGenerator = answerGenerator;
    }

    public void start() throws IOException {
        out.println("Welcome!");
        int roundCount = 6;

        String answer = answerGenerator.getRandomNumber();

        while (roundCount > 0) {
            out.println("Please input your number(" + roundCount + "):");

            String input = bufferedReader.readLine();
            String tips = guessNumber.getTips(input, answer);

            out.println(tips);
            roundCount--;

        }

        out.println("Game over!");
    }
}
