package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
    void createMoneyByInvalidInput(long unitsOf1000Won) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(unitsOf1000Won);
        });
    }
}