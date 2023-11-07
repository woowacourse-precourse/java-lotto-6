package validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberGeneratorValidatorTest {
    BonusNumberGeneratorValidator bonusNumberGeneratorValidator = new BonusNumberGeneratorValidator();

    @Test
    public void testVaildBonusNumberRangeValid() {
        int validBonusNumber = 5;
        assertDoesNotThrow(() -> bonusNumberGeneratorValidator.vaildBonusNumberRange(validBonusNumber));
    }

    @Test
    public void testVaildBonusNumberRangeInvalid() {
        int invalidBonusNumber = 55;
        assertThrows(IllegalArgumentException.class, () -> bonusNumberGeneratorValidator.vaildBonusNumberRange(invalidBonusNumber));
    }

    @Test
    public void testVaildBonusNumberNonNumericValid() {
        String validInput = "5";
        assertDoesNotThrow(() -> bonusNumberGeneratorValidator.vaildBonusNumberNonNumeric(validInput));
    }

    @Test
    public void testVaildBonusNumberNonNumericInvalid() {
        String invalidInput = "abc";
        assertThrows(IllegalArgumentException.class, () -> bonusNumberGeneratorValidator.vaildBonusNumberNonNumeric(invalidInput));
    }
}
