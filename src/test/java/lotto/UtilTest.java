package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @DisplayName("비용 입력 시 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createNotNumericPayment() {
        assertThatThrownBy(() -> Input.paymentToInteger(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
