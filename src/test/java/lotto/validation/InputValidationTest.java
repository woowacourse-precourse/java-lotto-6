package lotto.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @DisplayName("입력값이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validationNumberWithRemainder(){
        Assertions.assertThatThrownBy(()->new InputValidation().checkRemainder(42500))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validationInteger(){
        Assertions.assertThatThrownBy(()->new InputValidation().checkInteger("1sds"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
