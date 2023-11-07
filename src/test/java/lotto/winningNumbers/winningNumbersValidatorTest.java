package lotto.winningNumbers;

import lotto.validator.input.WinningNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class winningNumbersValidatorTest {
    private final WinningNumberValidator validator = new WinningNumberValidator();
    private String userInput;

    @Test
    void validate_당첨_번호는_쉼표를_기준으로_구분한다() {
        userInput = "1,2,3,4,5,6";
        validator.validateAndParse(userInput);
    }
    @Test
    void validate_당첨_번호들은_정수여야_한다() {
        userInput = "1,2,3,-4,-5,-6";
        validator.validateAndParse(userInput);
    }
    @Test
    void validate_당첨_번호가_정수가_아니면_거짓을_반환한다() {
        userInput = "1.0,2.5,-5.4";
        Assertions.assertThrows(IllegalArgumentException.class,()->validator.validateAndParse(userInput));
    }
    @Test
    void validate_입력이_없으면_거짓을_반환한다() {
        userInput = "";
        Assertions.assertThrows(IllegalArgumentException.class,()->validator.validateAndParse(userInput));
    }
    @Test
    void validate_구분자가_쉼표가_아니면_거짓을_반환한다() {
        userInput = "1|2|3|4|5|6";
        Assertions.assertThrows(IllegalArgumentException.class,()->validator.validateAndParse(userInput));
    }
    @Test
    void validate_쉼표와_다른_구분자가_섞여도_거짓을_반환한다() {
        userInput = "1,2 3,4|5|6";
        Assertions.assertThrows(IllegalArgumentException.class,()->validator.validateAndParse(userInput));
    }
    @Test
    void validate_앞뒤_공백이_있어도_거짓을_반환한다() {
        userInput = "   1,2,3,4,5,6   ";
        Assertions.assertThrows(IllegalArgumentException.class,()->validator.validateAndParse(userInput));
    }
}
