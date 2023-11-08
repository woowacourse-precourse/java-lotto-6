package lotto.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    public void testValidateList() {
        assertDoesNotThrow(() -> Validation.validateList("1,2,3,4,5"));
        assertThrows(LottoException.class, () -> Validation.validateList("1,2,3,4,invalid"));
    }
    @Test
    public void testINValidateInt() {

        assertThrows(LottoException.class, () -> Validation.validateInt("invalid"));
        assertThrows(LottoException.class, () -> Validation.validateInt(""));

        assertThrows(LottoException.class, () -> Validation.validateInt(null));
    }
}
