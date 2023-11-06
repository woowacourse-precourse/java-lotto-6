//import org.junit.jupiter.api.Test;
//
//package lotto;
//
//import lotto.Domain.BonusNumberValidator;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class BonusNumberTest {
//
//
//import org.junit.jupiter.api.Test;
//
//    @Test
//    public void validateIsNumeric_InvalidInput_ShouldThrowIllegalArgumentException() {
//        String invalidInput = "abc";
//
//import org.junit.jupiter.api.Test;
//        assertThrows(IllegalArgumentException.class, () -> BonusNumberValidator.validateIsNumeric(invalidInput));
//    }
//
//
//import org.junit.jupiter.api.Test;
//
//    @Test
//    public void validateIsNumberInRange_NumberOutOfRange_ShouldThrowIllegalArgumentException() {
//        int numberOutOfRange = 0;
//        assertThrows(IllegalArgumentException.class,
//                () -> BonusNumberValidator.validateIsNumberInRange(numberOutOfRange));
//    }
//}
