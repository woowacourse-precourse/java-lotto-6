package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.constant.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculatorTest {
    @DisplayName("5000원을 넣어 50000원(4등)에 당첨되었을 경우 수익률 계산")
    @Test
    public void calculateProfitRate() {
        //given
        int money = 5000;
        int totalPrize = 50000;
        Map<Prize, Integer> result = new LinkedHashMap<>();
        result.put(Prize.FOURTH, 1);
        result.put(Prize.NONE, 4);
        //when
        LottoCalculator calculator = new LottoCalculator(result);
        String profitRate = calculator.calculateProfitRate();
        double actual = ((double) totalPrize / money) * 100;
        DecimalFormat df = new DecimalFormat("#.0");
        String stringActual = df.format(actual);
        //then
        assertThat(profitRate).isEqualTo(stringActual);
    }

    @DisplayName("14000원을 넣어 5000원에 당첨되었을 경우 수익률 계산")
    @Test
    public void calculateLessRate() {
        int money = 14000;
        int totalPrize = 5000;
        Map<Prize, Integer> result = new LinkedHashMap<>();
        result.put(Prize.FIFTH, 1);
        result.put(Prize.NONE, 13);
        //when
        LottoCalculator calculator = new LottoCalculator(result);
        String profitRate = calculator.calculateProfitRate();
        double actual = ((double) totalPrize / money) * 100;
        DecimalFormat df = new DecimalFormat("#.0");
        String stringActual = df.format(actual);
        //then
        assertThat(profitRate).isEqualTo(stringActual);
    }
}