package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @DisplayName("금액 생성 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void createMoneyTest(int money) {
        assertThatCode(() -> new Money(money))
                .doesNotThrowAnyException();
    }

    @DisplayName("1000으로 나누어 떨어지지 않은 금액을 입력하면 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createMoneyByDoesNotDividedOneThousand(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
