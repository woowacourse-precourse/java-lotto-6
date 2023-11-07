package lotto.exception;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoExceptionTest {

    @Test
    @DisplayName("예외 출력시 \"[ERROR]\"가 포함 되야 한다.")
    void exception() throws LottoException {
        assertThatThrownBy(() -> {
            for (LottoException.ErrorMessage errorMessage : LottoException.ErrorMessage.values()) {
                throw new LottoException(errorMessage.getMessage());
            }
        })
                .isInstanceOf(LottoException.class)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}