package validator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerNumberGeneratorValidatorTest {
    WinnerNumberGeneratorValidator winnerNumberGeneratorValidator = new WinnerNumberGeneratorValidator();

    @Test
    public void testValidWinnerNumbersValidRange() {
        List<Integer> validWinnerNumbers = new ArrayList<>(Arrays.asList(11, 21, 13, 14, 35, 26));
        assertDoesNotThrow(() -> winnerNumberGeneratorValidator.vaildWinnerNumbers(validWinnerNumbers));
    }

    @Test
    public void testValidWinnerNumbersValidSize() {
        List<Integer> validWinnerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> winnerNumberGeneratorValidator.vaildWinnerNumbers(validWinnerNumbers));
    }

    @Test
    public void testValidWinnerNumbersValidDuplication() {
        List<Integer> validWinnerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> winnerNumberGeneratorValidator.vaildWinnerNumbers(validWinnerNumbers));
    }
}
