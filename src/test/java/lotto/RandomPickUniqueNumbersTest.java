package lotto;

import lotto.service.domain.random.RandomPickUniqueNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomPickUniqueNumbersTest {

    @Test
    public void randomSixPickTest(){
        List<Integer> list =
        RandomPickUniqueNumbers.getAutoUniqueNumbers(6);
        System.out.println(list);
    }


}
