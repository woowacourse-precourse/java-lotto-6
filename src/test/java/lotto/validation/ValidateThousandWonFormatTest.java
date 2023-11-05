package lotto.validation;

import lotto.exception.InvalidThousandWonFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateThousandWonFormatTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    @Test
    void inputMoneyByNotThousandWonFormat() {
        String inputMoney = "8080";

        assertThatThrownBy(() -> ValidateThousandWonFormat.validate(inputMoney))
                .isInstanceOf(InvalidThousandWonFormatException.class);
    }

}