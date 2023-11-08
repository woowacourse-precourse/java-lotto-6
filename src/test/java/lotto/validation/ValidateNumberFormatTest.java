package lotto.validation;

import lotto.exception.InvalidNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateNumberFormatTest {

    @DisplayName("구입 금액이 숫자형식이 아니면 예외를 발생시킨다.")
    @Test
    void inputMoneyByNotNumberFormat() {
        String inputMoney = "숫자";

        assertThatThrownBy(() -> ValidateNumberFormat.validate(inputMoney))
                .isInstanceOf(InvalidNumberFormatException.class);
    }

}