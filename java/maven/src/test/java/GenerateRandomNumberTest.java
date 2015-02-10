import com.sun.tools.javac.jvm.Gen;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Senela on 15-2-6.
 */
public class GenerateRandomNumberTest {

    @Test
    public void GetRandomNumber_first_string_different_with_others()
    {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber(new Random());
        String randomNumber = generateRandomNumber.getRandomNumber();

        String firstString =  randomNumber.substring(0, 1);
        assertThat(firstString.equals(randomNumber.substring(1, 2))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(2, 3))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }


    @Test
    public void GetRandomNumber_second_string_different_with_others()
    {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber(new Random());
        String randomNumber = generateRandomNumber.getRandomNumber();

        String firstString =  randomNumber.substring(1, 2);
        assertThat(firstString.equals(randomNumber.substring(0, 1))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(2, 3))).isEqualTo(false);
        assertThat(firstString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }

    @Test
    public void GetRandomNumber_third_string_different_with_others()
    {
        GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber(new Random());
        String randomNumber = generateRandomNumber.getRandomNumber();

        String thirdString =  randomNumber.substring(2, 3);
        assertThat(thirdString.equals(randomNumber.substring(0, 1))).isEqualTo(false);
        assertThat(thirdString.equals(randomNumber.substring(1, 2))).isEqualTo(false);
        assertThat(thirdString.equals(randomNumber.substring(3, 4))).isEqualTo(false);
    }

    @Test
    public void  should_generate_four_length_string()
    {
        String random = new GenerateRandomNumber(new Random()).getRandomNumber();
        assertThat(random.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_number()
    {
        String random = new GenerateRandomNumber(new Random()).getRandomNumber();
        try {
            Integer.parseInt(random);
        }catch (NumberFormatException e)
        {
            fail("random string should be number");
        }
    }

    @Test
    public void should_generator_random_string()
    {
       String random = new GenerateRandomNumber(new Random()).getRandomNumber();
        for(int i=0; i<random.length(); i++) {
            char oneChar = random.charAt(i);
            assertThat(random.indexOf(oneChar)).isEqualTo(random.lastIndexOf(oneChar));
        }
    }

    @Test
    public  void should_not_repeat_random_string()
    {
        Random random = mock(Random.class);
        when(random.nextInt(10)).
                thenReturn(1, 2, 3, 4).
                thenReturn(1, 2, 3, 4).
                thenReturn(2, 3, 4, 5).
                thenReturn(4, 5, 6, 7);

        GenerateRandomNumber  generateRandomNumber = new GenerateRandomNumber(random);
        Set<String> randomArr = new HashSet<String>();

        randomArr.add( generateRandomNumber.getRandomNumber());
        randomArr.add( generateRandomNumber.getRandomNumber());
        randomArr.add( generateRandomNumber.getRandomNumber());

        assertThat(randomArr.size()).isEqualTo(3);
    }

    @Test
    public  void should__repeatable_random_string_out_of_three_times()
    {
        Random random = mock(Random.class);
        when(random.nextInt(10)).
                thenReturn(1, 2, 3, 4).
                thenReturn(2, 3, 4, 5).
                thenReturn(4, 5, 6, 7).
                thenReturn(1, 2, 3, 4);

        GenerateRandomNumber  generateRandomNumber = new GenerateRandomNumber(random);
        Set<String> randomArr = new HashSet<String>();

        randomArr.add( generateRandomNumber.getRandomNumber());
        randomArr.add( generateRandomNumber.getRandomNumber());
        randomArr.add( generateRandomNumber.getRandomNumber());
        randomArr.add( generateRandomNumber.getRandomNumber());

        assertThat(randomArr.size()).isEqualTo(3);
    }

}
