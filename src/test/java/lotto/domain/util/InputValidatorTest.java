package lotto.domain.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 당첨번호_공백_빈줄_존재할경우() {
        String winNumber = "     ";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isEmptyOrBlank(winNumber);
        });
    }

    @Test
    void 보너스번호_공백_빈줄_존재할경우() {
        String bonusNumber = "";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isEmptyOrBlank(bonusNumber);
        });
    }
}