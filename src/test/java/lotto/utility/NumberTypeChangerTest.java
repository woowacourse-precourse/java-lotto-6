package lotto.utility;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTypeChangerTest {
    @DisplayName("구입 금액에 숫자를 입력한다.")
    @Test
    void testValidateNumber() {
        assertDoesNotThrow(() -> NumberTypeChanger.changeNumberType("1000"));
        assertDoesNotThrow(() -> NumberTypeChanger.changeNumberType("5000"));

        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("abc"));

        assertThrows(IllegalArgumentException.class, () -> NumberTypeChanger.changeNumberType("1000000000000"));
    }
}
