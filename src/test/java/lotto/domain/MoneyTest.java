package lotto.domain;

import static lotto.utils.ErrorMessages.MONEY_NOT_MULTIPLE_UNIT;
import static lotto.utils.ErrorMessages.MONEY_UNDER_MINIMUM;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Money 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1001, 1201})
    void 생성자는_입력값이_1000의_배수가_아닌_경우_예외를_던진다(int money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_NOT_MULTIPLE_UNIT);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1})
    void 생성자는_입력값이_1000보다_작은_경우_예외를_던진다(int money) {
        Assertions.assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_UNDER_MINIMUM);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "8000:8", "10000:10"}, delimiter = ':')
    void getBuyLottoQuantity_메소드는_구매_수량을_반환한다(int money, int expect) {
        Money testMoney = new Money(money);

        assertEquals(testMoney.getBuyLottoQuantity(), expect);
    }
}
