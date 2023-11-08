package lotto.model;

import static lotto.constant.BonusNumberTestConstant.BONUS_NUMBER;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_1;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_2;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_3;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_4;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_5;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_6;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_7;
import static lotto.constant.LottoTestConstant.LOTTO_NUMBERS_8;
import static lotto.constant.PaymentAmountTestConstant.PAYMENT_AMOUNT;
import static lotto.constant.WinningDetailTestConstant.TOTAL_PROFIT_RATE;
import static lotto.constant.WinningNumberTestConstant.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import lotto.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerTest {
    @Test
    @DisplayName("수익률을 구한다")
    void calculateProfitRateTest() {
        RandomUtil randomUtil = Mockito.mock(RandomUtil.class);

        when(randomUtil.createSortedRandomNumbersInRange(anyInt(), anyInt(), anyInt())).thenReturn(LOTTO_NUMBERS_1)
                .thenReturn(LOTTO_NUMBERS_2).thenReturn(LOTTO_NUMBERS_3).thenReturn(LOTTO_NUMBERS_4)
                .thenReturn(LOTTO_NUMBERS_5).thenReturn(LOTTO_NUMBERS_6).thenReturn(LOTTO_NUMBERS_7)
                .thenReturn(LOTTO_NUMBERS_8);
        Player player = new Player(Integer.parseInt(PAYMENT_AMOUNT.getValue()), randomUtil);

        double profitRate = player.calculateProfitRate(
                new WinningNumbers(WINNING_NUMBERS, Integer.parseInt(BONUS_NUMBER)));
        assertThat(String.format("%.1f", profitRate)).isEqualTo(String.format("%.1f", TOTAL_PROFIT_RATE));
    }
}