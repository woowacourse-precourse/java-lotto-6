package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 구입 금액 테스트")
class MoneyTest {
    private static final String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    @DisplayName("로또 구입 금액은 1000원 단위의 숫자일때 통과한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "1000000"})
    void money(String money) {
        assertThatCode(() -> new Money(money)).doesNotThrowAnyException();
    }

    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1sd0", "asdjkl;.,"})
    void moneyNotDigit(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TYPE_ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액이 1000원 단위의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100000"})
    void moneyZeroOrLess(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT_ERROR_MESSAGE);
    }
}