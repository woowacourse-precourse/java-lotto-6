package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.constant.LottoConstant;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoDrawTest implements LottoConstant {
    Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,PICK_COUNT));
    @Test
    @DisplayName("로또와 보너스 번호를 통해 LottoDraw 를 만든다.")
    void createLottoDrawWithLottoAndBonusNumber(){
        int bonusNumber = 13;
        LottoDraw lottoDraw = new LottoDraw(lotto,bonusNumber);
        Assertions.assertEquals(LottoDraw.class,lottoDraw.getClass());
    }
    @Test
    @DisplayName("로또 번호들에 있는 보너스 번호를 입력하면 예외를 발생한다.")
    void throwExceptionWhenLottoContainBonusNumber(){
        var duplicatedBonusNumber = lotto.getNumbers().get(0);
        Assertions.assertThrows(LottoException.class,()->{
            new LottoDraw(lotto,duplicatedBonusNumber);
        });
    }
    @Test
    @DisplayName("범위 밖에 있는 보너스 번호를 입력하면 예외를 발생한다.")
    void throwExceptionWhenBonusNumberIsOutRange(){
        var outBonusNumber = MAX_NUMBER+1;
        Assertions.assertThrows(LottoException.class,()->{
            new LottoDraw(lotto,outBonusNumber);
        });
    }
}
