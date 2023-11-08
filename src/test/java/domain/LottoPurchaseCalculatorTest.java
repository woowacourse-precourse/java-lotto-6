package domain;

import lotto.domain.model.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaseCalculatorTest {

    @ParameterizedTest
    @CsvSource({"3000, 3", "2000, 2", "5000, 5"})
    @DisplayName("올바른 금액과 가격으로 로또 개수 계산")
    void validLottoCount(int amount, int expected) {
        Money money = new Money(amount);

        int count = money.calculateLottoCount();

        assertThat(count).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -100, -1000})
    @DisplayName("부적절한 로또 가격으로 인한 예외 발생")
    void invalidPrice(int amount) {

        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 양수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 2500, 5})
    @DisplayName("나누어 떨어지지 않는 금액으로 인한 예외 발생")
    void nonDivisibleAmount(int amount) {

        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 로또 가격 단위로 나누어 떨어져야 합니다.");
    }
}