package lotto.input;

import lotto.view.input.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("PurchaseAmount 입력 검증 테스트")
class PurchaseAmountValidatorTest {

    private String userInput;
    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Test
    @DisplayName("양의 정수면 성공이다.")
    void success1() {
        userInput = "2";
        validator.validate(userInput);
    }

    @Test
    @DisplayName("음의 정수면 성공이다.")
    void success2() {
        userInput = "-20";
        validator.validate(userInput);
    }

    @Test
    @DisplayName("실수면 예외가 발생한다.")
    void fail1() {
        userInput = "5.2";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("값이 없으면 예외가 발생한다.")
    void fail2() {
        userInput = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("문자가 들어오면 예외가 발생한다.")
    void fail3() {
        userInput = "&";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("앞에 공백이 있으면 예외가 발생한다.")
    void fail4() {
        userInput = "   5";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("뒤에 공백이 있으면 예외가 발생한다.")
    void fail5() {
        userInput = "5   ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("숫자 사이에 공백이 있으면 예외가 발생한다.")
    void fail6() {
        userInput = "1    2";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }
}