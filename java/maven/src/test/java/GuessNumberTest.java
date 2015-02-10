import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Senela on 15-1-31.
 */
public class GuessNumberTest {

    private  String randomNumber;

    @Before
    public void  setUp()
    {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        randomNumber = answerGenerator.getRandomNumber();
    }

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

    @Test
    public void GetRandomNumber_first_string_different_with_others()
    {


        String firstString =  randomNumber.substring(0, 1);
        assertThat(firstString.equals(randomNumber.substring(1, 2))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(2, 3))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }


    @Test
    public void GetRandomNumber_second_string_different_with_others()
    {
        String firstString =  randomNumber.substring(1, 2);
        assertThat(firstString.equals(randomNumber.substring(0, 1))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(2, 3))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }

    @Test
    public void GetRandomNumber_third_string_different_with_others()
    {
        String thirdString =  randomNumber.substring(2, 3);
        assertThat(thirdString.equals(randomNumber.substring(0, 1))).isEqualTo(false);
        assertThat(thirdString.equals(randomNumber.substring(1, 2))).isEqualTo(false);
        assertThat(thirdString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }

}
