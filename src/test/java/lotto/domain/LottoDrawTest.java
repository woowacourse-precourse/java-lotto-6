package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDrawTest {
    @Test
    @DisplayName("로또와 보너스 번호를 통해 LottoDraw 를 만든다.")
    void createLottoDrawWithLottoAndBonusNumber(){
        var randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Lotto lotto = new Lotto(randomNumbers);
        int bonusNumber = 13;
        LottoDraw lottoDraw = new LottoDraw(lotto,bonusNumber);
        Assertions.assertEquals(LottoDraw.class,lottoDraw.getClass());
    }
    @Test
    @DisplayName("로또 번호들에 있는 보너스 번호를 입력하면 예외를 발생한다.")
    void throwExceptionWhenLottoContainBonusNumber(){
        var randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Lotto lotto = new Lotto(randomNumbers);
        var duplicatedBonusNumber = lotto.getNumbers().get(0);
        Assertions.assertThrows(LottoException.class,()->{
            new LottoDraw(lotto,duplicatedBonusNumber);
        });

    }

}
