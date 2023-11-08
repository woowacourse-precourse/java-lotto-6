package lotto;

import static lotto.constant.Constants.BONUS_BALL;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    private ProfitCalculator profitCalculator = new ProfitCalculator();

    @Test
    void calculateProfit() {

        //given
        int moneyInput = 8000;
        Map<Integer, Integer> winners = new HashMap<>();
        winners.put(3, 1);
        winners.put(4, 0);
        winners.put(5, 0);
        winners.put(6, 0);
        winners.put(5 + BONUS_BALL, 0);
        //when
        double profit = profitCalculator.calculateProfit(moneyInput, winners);

        //then
        Assertions.assertThat(profit).isEqualTo(62.5);

    }
}