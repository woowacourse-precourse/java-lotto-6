package lotto.view.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static lotto.view.validation.InputValidation.inputValidate;
class InputValidationTest {

    @Test
    @DisplayName("빈칸이 입력되면 에러를 발생시킨다")
    void inputEmptyTest() {
        // given
        String input = "";
        // then
        Assertions.assertThatThrownBy( () -> inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백이 입력되면 에러를 발생시킨다")
    void inputBlankTest() {
        // given
        String input = " ";
        // then
        Assertions.assertThatThrownBy( () -> inputValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}