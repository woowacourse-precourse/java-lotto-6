package lotto.validator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.util.validator.AmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AmountValidatorTest {
    private final AmountValidator amountValidator = new AmountValidator();

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(숫자가 아님)")
    @Test
    void validationNumericTest() {
        String input = "가";

        boolean result = amountValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력이 아닐 경우 false를 리턴한다(1000원 단위가 아님)")
    @Test
    void validationDivideThousandTest() {
        String input = "10123";

        boolean result = amountValidator.validation(input);

        assertThat(result).isFalse();

    }

    @DisplayName("올바른 입력일 경우 True를 리턴한다")
    @Test
    void validationTest() {
        String input = "10000";

        boolean result = amountValidator.validation(input);

        assertThat(result).isTrue();

    }

}
