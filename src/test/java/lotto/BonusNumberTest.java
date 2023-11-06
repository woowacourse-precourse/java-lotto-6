//package lotto;
//
//import lotto.Domain.BonusNumberValidator;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class BonusNumberTest {
//
//    @Test
//    public void validateIsNumeric_InvalidInput_ShouldThrowIllegalArgumentException() {
//        String invalidInput = "abc";
//        assertThrows(IllegalArgumentException.class, () -> BonusNumberValidator.validateIsNumeric(invalidInput));
//    }
//
//    @Test
//    public void validateIsNumberInRange_NumberOutOfRange_ShouldThrowIllegalArgumentException() {
//        int numberOutOfRange = 0;
//        assertThrows(IllegalArgumentException.class, () -> BonusNumberValidator.validateIsNumberInRange(numberOutOfRange));
//    }
//}
