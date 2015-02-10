import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Senela on 15-2-6.
 */
public class GenerateRandomNumber {

    private final Random random;
    private final List<String> historyRandomString;

    public GenerateRandomNumber(Random random) {
        this.random = random;
        this.historyRandomString = new ArrayList<String>();
    }

    public String getRandomNumber() {

        String randomString = generatorRandomNumber();
        while(historyRandomString.contains(randomString))
        {
             randomString = generatorRandomNumber();
        }

        if(historyRandomString.size() == 2)
            historyRandomString.remove(0);

        historyRandomString.add(randomString);

        return randomString;
    }

    public String generatorRandomNumber()
    {
        StringBuffer randomString = new StringBuffer();
        while(randomString.length()<4)
        {
            String digit = String.valueOf( random.nextInt(10));
            if( randomString.indexOf(digit) == -1)
                randomString.append(digit);
        }
        return randomString.toString();
    }
}
