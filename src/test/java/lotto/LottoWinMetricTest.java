package lotto;

import static lotto.LottoWinMetric.*;
import static lotto.LottoWinMetric.FIRST;
import static lotto.LottoWinMetric.getLottoWinMetric;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoWinMetricTest {

    @Test
    public void getMessageAndIncreaseTest() {
        // when
        FIRST.initCount();
        FIRST.increase();

        // then
        assertEquals(FIRST.getMessage(), "6개 일치 (2,000,000,000원) - 1개");
    }

    @Test
    public void getLottoWinMetric_third_test() {
        // when
        LottoWinMetric result = getLottoWinMetric(5, false);

        // then
        assertEquals(result, THIRD);
    }

    @Test
    public void getLottoWinMetric_second_test() {
        // when
        LottoWinMetric result = getLottoWinMetric(5, true);

        // then
        assertEquals(result, SECOND);
    }

    @Test
    public void getTotalWinMoney_test() {
        // given
        FOURTH.initCount();
        FOURTH.increase();
        FIFTH.initCount();
        FIFTH.increase();

        // when
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        int result = getTotalWinMoney().get();

        // then
        assertEquals(result, 55000);
    }
}