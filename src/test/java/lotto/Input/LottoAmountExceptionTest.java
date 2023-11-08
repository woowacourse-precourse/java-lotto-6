package lotto.Input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountExceptionTest {

    @DisplayName("로또 구입 금액 1000원 단위 아니면 예외 발생")
    @Test
    void validate() {
        assertThatThrownBy(() -> new LottoAmountException(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1000원 단위로만 구매 가능합니다.");
    }
}