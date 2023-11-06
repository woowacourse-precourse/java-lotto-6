package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.amount.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Amount 클래스")
class AmountTest {

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않는다면 예외를 발생한다.")
    @Test
    void createAmountByNumber() {
        assertThatThrownBy(() -> Amount.of(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 미만이라면 예외를 발생한다.")
    @Test
    void createAmountLessThanThousand() {
        assertThatThrownBy(() -> Amount.of(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}