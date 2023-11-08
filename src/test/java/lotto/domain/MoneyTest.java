package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.view.input.error.InputIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    private static final int PRICE = 1000;

    @DisplayName("money 생성")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000})
    void createMoneyWithAmount(long amount) {
        Money money = Money.getInstance(amount);
        long lotteryCount = amount / PRICE;

        assertEquals(lotteryCount, money.getLotteryCount());
    }

    @DisplayName("음수로 money 생성")
    @ParameterizedTest
    @ValueSource(longs = {-1000, -2000, -3000})
    void createMoneyWithNegative(long amount) {
        assertThrows(InputIllegalArgumentException.class, () -> Money.getInstance(amount));
    }

    @DisplayName("PRICE로 나누어 지지 않는 money 생성")
    @ParameterizedTest
    @ValueSource(longs = {1500, 3099, 2999})
    void createMoneyWithNotDivide(long amount) {
        assertThrows(InputIllegalArgumentException.class, () -> Money.getInstance(amount));
    }
}
