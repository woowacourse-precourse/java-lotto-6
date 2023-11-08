package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyValidatorTest {

    private final MoneyValidator moneyValidator = new MoneyValidator();

    @ParameterizedTest
    @ValueSource(ints = {1003, 999, 104397})
    @DisplayName("입력 값이 1,000 단위가 아닐 때 예외 처리 테스트")
    void input_validate_when_not_divisible_with_1000(Integer amount) {
        assertThatThrownBy(() -> moneyValidator.validate(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("입력 값이 1,000보다 작은 경우 예외 처리 테스트")
    void input_validate_when_less_than_1000() {
        assertThatThrownBy(() -> moneyValidator.validate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000보다 작을 수 없습니다.");
    }

}