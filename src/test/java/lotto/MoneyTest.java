package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1111, -1000})
    void createMoneyByOutOfRangeNumber(int purchaseMoney) {
        assertThatThrownBy(() -> new Money(purchaseMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "30000,30"})
    void getLottoCount(int purchaseMoney, int expected) {
        Money money = new Money(purchaseMoney);
        int count = money.getLottoCount();
        assertThat(count).isEqualTo(expected);
    }
}
