package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceValidatorTest {
    private final PriceValidator priceValidator = new PriceValidator();

    @DisplayName("구매 금액이 입력되지 않으면 예외가 발생한다.")
    @Test
    void priceIsEmpty() {
        assertThatThrownBy(() -> priceValidator.checkPriceValidate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자 이외의 문자가 포함되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123a","abc","a1000"," 100","  2  "})
    void priceContainNonNumericCharacter(String input) {
        assertThatThrownBy(() -> priceValidator.checkPriceValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000","-10000","-20000"})
    void priceIsNegative(String input) {
        assertThatThrownBy(() -> priceValidator.checkPriceValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}