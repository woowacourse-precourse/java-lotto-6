package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AmountValidatorTest {
    @Test
    void validateAmountByZero() {
        assertThatThrownBy(() -> AmountValidator.validateAmount(BigDecimal.ZERO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 0을 입력할 수 없습니다.");
    }

    @DisplayName(value = "1000 단위로 떨어지지 않을 경우 예외가 발생한다.")
    @ParameterizedTest(name = "{index} ==> 투입금액 : {0}")
    @CsvSource(value = {"1001", "10005", "21239"})
    void validateAmountByImproperNumber(int inputMoney) {
        assertThatThrownBy(() -> AmountValidator.validateAmount(new BigDecimal(inputMoney)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000 단위로만 입력 가능합니다.");
    }
}
