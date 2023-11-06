package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.AmountValidator;
import lotto.domain.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    public static Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new AmountValidator();
    }

    @DisplayName("입력한 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "천삼백원", "100 00", "-1000", "10000.00", "1천원" })
    public void testValidateNumeric(String input) {
        AmountValidator amountValidator = (AmountValidator) validator;
        assertThatThrownBy(() -> amountValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = { "0", "10", "100" })
    public void testValidateUnitThousand() {
        AmountValidator amountValidator = (AmountValidator) validator;
        assertThatThrownBy(() -> amountValidator.validateUnitThousand("1300"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
