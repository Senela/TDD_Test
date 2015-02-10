import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Senela on 15-1-31.
 */
public class GuessNumberTest {
    @Test
    public void  GuessNumberTest4A0B() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","1234")).isEqualTo("4A0B");
    }

    @Test
    public void  GuessNumberTest0A4B() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","4321")).isEqualTo("0A4B");
    }

    @Test
    public void  GuessNumberTest0A0B() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","5678")).isEqualTo("0A0B");
    }

    @Test
    public void  GuessNumber_return_1A0B_when_input_is_1234_and_answer_is_1567() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","1567")).isEqualTo("1A0B");
    }


    @Test
    public void  GuessNumber_return_2A0B_when_input_is_1234_and_answer_is_1267() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","1267")).isEqualTo("2A0B");
    }

    @Test
    public void  GuessNumber_return_3A0B_when_input_is_1234_and_answer_is_1237() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","1237")).isEqualTo("3A0B");
    }

    @Test
    public void  GuessNumber_return_0A1B_when_input_is_1234_and_answer_is_4567() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","4567")).isEqualTo("0A1B");
    }


    @Test
    public void  GuessNumber_return_0A2B_when_input_is_1234_and_answer_is_4367() {
        GuessNumber guessNumber = new GuessNumber();
        assertThat(guessNumber.getTips("1234","4367")).isEqualTo("0A2B");
    }


}
