package lotto.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;
import static lotto.handler.ErrorHandler.INVALID_NEGATIVE_INPUT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("구입 금액에 숫자로 변환될 수 없는 타입이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"200j0", "199@", "200 ", "20공0"})
    void createMoneyByInconvertibleType(String inputValue) {
        assertThatThrownBy(() -> Money.create(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INCONVERTIBLE_TYPE.getException().getMessage());
    }

    @DisplayName("구입 금액에 0원 이하의 값이 들어오면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] input {0} " )
    @ValueSource(strings = {"0", "-1", "-50"})
    void createMoneyByInvalidInput(String inputValue) {
        assertThatThrownBy(() -> Money.create(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NEGATIVE_INPUT.getException().getMessage());
    }
}
