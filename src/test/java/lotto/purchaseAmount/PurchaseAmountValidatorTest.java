package lotto.purchaseAmount;

import lotto.validator.input.PurchaseAmountValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    private final PurchaseAmountValidator validator = new PurchaseAmountValidator();
    private String userInput;

    @Test
    void validate_양의_정수면_참을_반환한다() {
        userInput = "2";
        validator.validateAndParse(userInput);
    }
    @Test
    void validate_음의_정수면_참을_반환한다() {
        userInput = "-20";
        validator.validateAndParse(userInput);
    }

    @Test
    void validate_실수면_거짓을_반환한다() {
        userInput = "5.2";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }

    @Test
    void validate_값이_없으면_거짓을_반환한다() {
        userInput = "";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }
    @Test
    void validate_문자가_들어오면_거짓을_반환한다() {
        userInput = "&";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }

    @Test
    void validate_앞에_공백이_있으면_거짓을_반환한다() {
        userInput = "   5";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }
    @Test
    void validate_뒤에_공백이_있으면_거짓을_반환한다() {
        userInput = "5   ";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }

    @Test
    void validate_숫자_사이에_공백이_있으면_거짓을_반환한다() {
        userInput = "1    2";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> validator.validateAndParse(userInput));
    }
}