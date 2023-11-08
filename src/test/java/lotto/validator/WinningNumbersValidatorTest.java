package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersValidatorTest {
    private WinningNumbersValidator validator = new WinningNumbersValidator();

    @Test
    void validate_정상적인_숫자일_경우() {
        validator.validate("1,2,3,4,5,6");
    }

    @Test
    void validate_숫자가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc,def,ghi"));
    }

    @Test
    void validate_6개의_숫자가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1,2,3,4,5"));
    }

    @Test
    void validate_최소_값보다_작은_숫자일_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0,1,2,3,4,5"));
    }

    @Test
    void validate_최대_값보다_큰_숫자일_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1,2,3,4,5,46"));
    }

    @Test
    void validate_중복된_숫자가_있는_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1,2,3,4,1,2"));
    }
}