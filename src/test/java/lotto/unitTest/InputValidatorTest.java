package lotto.unitTest;

import lotto.constant.Error;
import lotto.input.InputValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000","8000","12000"})
    @DisplayName("로또 구입 금액은 1000으로 나누어 떨어져야 한다")
    public void testCheckLottoPurchaseAmountValid(String validInput) {
        try {
            InputValidator.checkPurchaseAmount(validInput);
        } catch (IllegalArgumentException e) {
            fail("예외가 발생해서는 안됩니다.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings={"abc",""," ","hEl22k","안녕!","-1000"})
    @DisplayName("로또 구입 금액을 입력받을때 숫자가 아니면 예외가 발생한다.")
    public void testCheckLottoPurchaseAmountInvalidNotNumber(String invalidInput) {

        try {
            InputValidator.checkPurchaseAmount(invalidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertEquals(Error.NOT_NUMBER,e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"100","900","1001","100000002","1000100","1234456"})
    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    public void testCheckLottoPurchaseAmountInvalidNotDividedBy1000(String invalidInput) {
        try {
            InputValidator.checkPurchaseAmount(invalidInput);
            fail("IllegalArgumentException이 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertEquals(Error.DO_NOT_DIVIDED_BY_1000, e.getMessage());
        }
    }
}
