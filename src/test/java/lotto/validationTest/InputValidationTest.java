package lotto.validationTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidationTest {

    private final InputValidation inputValidation = new InputValidation();

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우")
    public void isNameTest() {
        assertThatThrownBy(() -> {
            inputValidation.isNumber("8000원");
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    public void isThousandMultipleTest() {
        assertThatThrownBy(() -> {
            inputValidation.isThousandMultiple("5500");
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
    }
}
