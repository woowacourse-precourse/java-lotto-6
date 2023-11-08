package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberValidatorTest {
    private BonusNumberValidator validator = new BonusNumberValidator(Arrays.asList(1, 2, 3, 4, 5));

    @Test
    void validate_정상적인_숫자일_경우() {
        validator.validate("6");
    }

    @Test
    void validate_숫자가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
    }

    @Test
    void validate_최소_값보다_작은_숫자일_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("0"));
    }

    @Test
    void validate_최대_값보다_큰_숫자일_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("46"));
    }

    @Test
    void validate_이미_당첨된_숫자일_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1"));
    }
}