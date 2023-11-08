package lotto.input;

import lotto.view.input.validator.WinningNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("winningNumbers 입력 검증 테스트")
public class winningNumbersValidatorTest {
    private final WinningNumberValidator validator = new WinningNumberValidator();
    private String userInput;

    @Test
    @DisplayName("당첨 번호가 쉼표로 구분되면 성공한다.")
    void success1() {
        userInput = "1,2,3,4,5,6";
        validator.validate(userInput);
    }

    @Test
    @DisplayName("당첨 번호가 모두 정수면 성공한다.")
    void success2() {
        userInput = "1,2,3,-4,-5,-6";
        validator.validate(userInput);
    }

    @Test
    @DisplayName("당첨 번호가 모두 정수가 아니면 예외가 발생한다.")
    void fail1() {
        userInput = "1.0,2.5,-5.4";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("입력이 없으면 예외가 발생한다.")
    void fail2() {
        userInput = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("당첨 번호가 쉼표로 구분되지 않으면 예외가 발생한다.")
    void fail3() {
        userInput = "1|2|3|4|5|6";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("쉼표와 다른 구분자가 섞이면 예외가 발생한다.")
    void fail4() {
        userInput = "1,2 3,4|5|6";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }

    @Test
    @DisplayName("앞 뒤 공백이 있으면 예외가 발생한다.")
    void fail5() {
        userInput = "   1,2,3,4,5,6   ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(userInput));
    }
}
