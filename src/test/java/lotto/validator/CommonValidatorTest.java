package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.ENTER_PROPER_NATURAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

class CommonValidatorTest {
    @Test
    @DisplayName("입력된 값이 10억 이하의 자연수인지 검증한다.")
    void validateIsNaturalNumber() {
        Assertions.assertThatThrownBy(() -> CommonValidator.validateIsNaturalNumber("String"))
                .hasMessage(ENTER_PROPER_NATURAL_NUMBER);

        Assertions.assertThatThrownBy(() -> CommonValidator.validateIsNaturalNumber("1000000000")) // 10억
                .hasMessage(ENTER_PROPER_NATURAL_NUMBER);

        CommonValidator.validateIsNaturalNumber("300000");
    }
}