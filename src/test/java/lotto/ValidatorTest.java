package lotto;

import lotto.util.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void whenInputIsValidInteger_thenCorrect() {
        assertEquals(1000, validator.validatePurchaseAmountInput("1000"));
    }

    @Test
    public void whenInputIsNotInteger_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmountInput("abc");
        });
    }

    @Test
    public void whenInputIsNotPositive_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmountInput("-1000");
        });
    }

    @Test
    public void whenInputIsNotMultipleOfThousand_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePurchaseAmountInput("1500");
        });
    }

    @Test
    public void whenLottoNumbersInputIsValid_thenCorrect() {
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, validator.validateLottoNumbersInput("1, 2, 3, 4, 5, 6"));
    }

    @Test
    public void whenLottoNumbersInputIsNotSixNumbers_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateLottoNumbersInput("1, 2, 3, 4, 5");
        });
    }

    @Test
    public void whenLottoNumbersInputHasDuplicates_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateLottoNumbersInput("1, 2, 3, 3, 4, 5");
        });
    }

    @Test
    public void whenLottoNumbersOutOfRange_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateLottoNumbersInput("1, 2, 3, 46, 5, 6");
        });
    }

    @Test
    public void whenBonusNumberIsDuplicatedWithWinningLottoNumbers_thenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            validator.compareWithLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

    @Test
    public void whenBonusNumberIsValid_thenNoException() {
        assertDoesNotThrow(() -> {
            validator.compareWithLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        });
    }
}
