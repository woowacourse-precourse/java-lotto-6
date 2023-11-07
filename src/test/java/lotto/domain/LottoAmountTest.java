package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.ValidateMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @DisplayName("숫자가 아닌 입력.")
    @Test
    void createLottoAmountByDifferentTypes() {
        assertThatThrownBy(() -> new LottoAmount("as@"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NUMBER_MESSAGE);
    }
    @DisplayName("1000단위 입력 테스트.")
    @Test
    void createLottoAmountByThousand() {
        assertThatThrownBy(() -> new LottoAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_THOUSAND_MESSAGE);
    }
    @DisplayName("0 입력 테스트.")
    @Test
    void createLottoAmountByZero() {
        assertThatThrownBy(() -> new LottoAmount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_ZERO_MESSAGE);
    }

}
