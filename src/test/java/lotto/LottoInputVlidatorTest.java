package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.Controller.LottoInputValidator;
import org.junit.jupiter.api.Test;

class LottoInputVlidatorTest {

    private final LottoInputValidator validator = new LottoInputValidator();

    @Test
    void testValidateBudgetWithValidInput() {
        assertDoesNotThrow(() -> validator.validateBudget("6000"));
    }

    @Test
    void testValidateBudgetWithInvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateBudget("abc"));
        assertEquals("[ERROR] 구입 금액이 숫자가아닙니다.", exception.getMessage());
    }

    @Test
    void testValidateBudgetWithInvalidValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validateBudget("500"));
        assertEquals("[ERROR] 예산은 0보다 크고 1000으로 나누어 떨어져야 합니다.\n", exception.getMessage());
    }

    @Test
    void testValidateNormalNumbersIsIntegerWithValidInput() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(numbers, validator.validateNormalNumbersIsInteger("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void testValidateNormalNumbersIsIntegerWithInvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateNormalNumbersIsInteger("1, 2, a, 4, 5, 6"));
        assertEquals("[ERROR] 당첨번호는 숫자여야합니다.", exception.getMessage());
    }

    @Test
    void testValidateNormalNumberCountWithValidInput() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> validator.validateNormalNumberCount(numbers));
    }

    @Test
    void testValidateNormalNumberCountWithInvalidInput() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                validator.validateNormalNumberCount(numbers));
        assertEquals("[ERROR] 당첨 번호를 6개 입력해야합니다.", exception.getMessage());
    }

}
