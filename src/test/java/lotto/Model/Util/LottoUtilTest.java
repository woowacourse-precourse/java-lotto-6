package lotto.Model.Util;

import static org.junit.jupiter.api.Assertions.*;

import lotto.Model.Domain.Lotto;
import System.Constant;
import org.junit.jupiter.api.Test;

class LottoUtilTest {

    private LottoUtil lottoUtil = new LottoUtil();

    @Test
    public void testPickLottoNumber() {
        Lotto result = lottoUtil.pickLottoNumber();

        assertNotNull(result);
        assertEquals(6, result.getNumbers().size());
        for (int number : result.getNumbers()) {
            assertTrue(number >= Constant.LOTTO_MIN_VALUE.getConstant()
                    && number <= Constant.LOTTO_MAX_VALUE.getConstant());
        }
    }

    @Test
    public void testCalculateCount() {
        int money = 10000;
        int expectedCount = money / 1000;
        assertEquals(expectedCount, lottoUtil.calculateCount(money));
    }
}