package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RevenueTest {

    @DisplayName("로또를 사기위한 금액 입력 시, 문자열이 들어가있으면 예외가 발생한다.")
    @Test
    void validateInputCostIsNumException() {
        assertThatThrownBy(() -> validateInputIsNum("1000z"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
