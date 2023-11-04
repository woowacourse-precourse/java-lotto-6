package lotto;

import lotto.service.domain.random.CreateRandomNumberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateRandomNumberServiceTest {
    @Test
    public void randomSixPickTest(){
        List<Integer> list =
        CreateRandomNumberService.getAutoUniqueNumbers(6);
        System.out.println(list);
        Assertions.assertNotNull(list);
    }
    @Test
    public void randomBonusTest(){
        List<Integer> lottoNumberSix =
          CreateRandomNumberService.getAutoUniqueNumbers(6);
        int bonusNumber = CreateRandomNumberService.getBonusNumber();
        System.out.println(lottoNumberSix);
        System.out.println(bonusNumber);
        Assertions.assertNotEquals(lottoNumberSix,bonusNumber);
    }
}
