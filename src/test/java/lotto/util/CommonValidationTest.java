package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonValidationTest {

    @Test
    @DisplayName("입력값이 공백이라면 예외가 발생한다.")
    void isBlank() {
        Assertions.assertThatThrownBy(()-> CommonValidation.validate("1 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 허용되지 않습니다.");
    }
    @Test
    @DisplayName("입력값이 0이라면 예외가 발생한다.")
    void isZero() {
        Assertions.assertThatThrownBy(()-> CommonValidation.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이상의 숫자로 입력해야 합니다.");
    }
    @Test
    @DisplayName("입력값이 공백이라면 예외가 발생한다.")
    void isNumber() {
        Assertions.assertThatThrownBy(()-> CommonValidation.validate("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해주세요.");
    }
}