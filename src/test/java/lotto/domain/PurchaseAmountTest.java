package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("입력한 구매 금액이 2147483000 초과이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByOverValue() {
        assertThatThrownBy(() -> new PurchaseAmount(2147483001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MAX_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호의 값이 1000 미만이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByUnderValue() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_PURCHASE_MIN_RANGE.getMessage());
    }

}