package lotto;

import lotto.service.domain.random.RandomPickUniqueNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomPickUniqueNumbersTest {

    @Test
    public void randomSixPickTest(){
        List<Integer> list =
        RandomPickUniqueNumbers.getAutoUniqueNumbers(6);
        System.out.println(list);
        Assertions.assertNotNull(list);
    }

    @Test
    public void randomBonusTest(){
        List<Integer> lottoNumberSix =
          RandomPickUniqueNumbers.getAutoUniqueNumbers(6);
        int bonusNumber = RandomPickUniqueNumbers.getBonusNumber();
        System.out.println(lottoNumberSix);
        System.out.println(bonusNumber);
        Assertions.assertNotEquals(lottoNumberSix,bonusNumber);
    }
}
