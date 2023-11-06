package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import lotto.controller.validator.BonusNumberValidator;
import lotto.utils.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    void testValidBonusNumber() {
        String validBonusNumber = "10"; // Assuming 7 is a valid bonus number
        assertThatCode(() -> bonusNumberValidator.validate(validBonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void testNonNumericBonusNumber() {
        String nonNumeric = "A"; // Non-numeric character
        assertThatThrownBy(() -> bonusNumberValidator.validate(nonNumeric))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NON_NUMERIC_EXCEPTION_MESSAGE);
    }

    @Test
    void testOutOfRangeBonusNumber() {
        // Test cases for invalid bonus numbers

        String smallerNumber = "0"; // Less than MIN_LOTTO_NUMBER
        String biggerNumber = "50"; // Greater than MAX_LOTTO_NUMBER

        assertThatThrownBy(() -> bonusNumberValidator.validate(smallerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);

        assertThatThrownBy(() -> bonusNumberValidator.validate(biggerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }
}