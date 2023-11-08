package lotto.domain.lotto;

import lotto.domain.Money;
import lotto.domain.winning.WinningGrade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCalculatorTest {
    private final LottoCalculator calculator = new LottoCalculator();

    @DisplayName("수익률은 (총 상금 / 구매 금액) * 100 이다.")
    @Test
    void createYieldByTotalPrizeAndMoneySpent() {
        Map<WinningGrade, Integer> winningResult = new EnumMap<>(WinningGrade.class);
        winningResult.put(WinningGrade.FIFTH, 1);

        Money money = new Money(8000);

        double yield = calculator.calculate(money, winningResult);
        double expected = ((double) 5000 / 8000) * 100;
        assertEquals(expected, yield);
    }
}