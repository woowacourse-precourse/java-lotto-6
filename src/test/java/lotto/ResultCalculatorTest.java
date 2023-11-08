package lotto;

import static lotto.LottoWinMetric.FIRST;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.message.BonusNumber;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {

    @Test
    public void calculateWinTest() {
        // given
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        List<Lotto> lottoNumbers = Lists.newArrayList(lotto);

        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");

        // when
        FIRST.initCount();
        ResultCalculator.calculateWin(lottoNumbers, winLotto, bonusNumber);

        // then
        assertEquals(FIRST.getMessage(), "6개 일치 (2,000,000,000원) - 1개");
    }
}