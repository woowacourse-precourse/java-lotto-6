package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("천원 단위로 정상적으로 돈이 생성된다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000})
    void createMoneyByUnitsOf1000Won(long unitsOf1000Won) {
        Money money = new Money(unitsOf1000Won);
        assertNotNull(money);
    }

    @DisplayName("비정상적인 입력으로 돈을 생성하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(longs = {10001, -1000, 123})
    void createMoneyByInvalidInput(long invalidInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(invalidInput);
        });
    }

    @DisplayName("구입 가능한 로또의 수를 계산한다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000})
    void calculatePurchasableLottosCount(long validInput) {
        Money money = new Money(validInput);
        long actualPurchasableLottosCount = money.calculatePurchasableLottosCount();
        long expectedPurchasableLottosCount = validInput / 1000;

        assertEquals(expectedPurchasableLottosCount, actualPurchasableLottosCount);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource({"1000,50000,5000", "3000,2000000,66666.7"})
    void calculateRateOfReturn(long money, long winningPrize, double actualRateOfReturn) {
        Money purchaseMoney = new Money(money);
        Money totalWinningPrize = new Money(winningPrize);

        double expectedRateOfReturn = purchaseMoney.calculateRateOfReturn(totalWinningPrize);
        assertEquals(actualRateOfReturn, expectedRateOfReturn);
    }
}