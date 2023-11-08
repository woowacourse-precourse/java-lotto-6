package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    @DisplayName("구매금액이 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createAmountOutOfRange() {
        assertThatThrownBy(() -> new Amount(100))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Amount(99999999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createAmountNotDivisibleBy1000() {
        assertThatThrownBy(() -> new Amount(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
