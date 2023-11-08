package lotto.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoPayAmountValidatorTest {
    private LottoPayAmountValidator validator = new LottoPayAmountValidator();

    @Test
    void validate_정상적인_금액일_경우() {
        validator.validate("10000");
    }

    @Test
    void validate_금액이_숫자가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("abc"));
    }

    @Test
    void validate_금액이_천원_단위가_아닐_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("10001"));
    }

    @Test
    void validate_금액이_최대_값을_초과할_경우() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("2000000001"));
    }
}