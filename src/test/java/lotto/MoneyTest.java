package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.money.MoneyPositiveException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("화폐의 금액이 0원 이하이면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeValue() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(MoneyPositiveException.class);
    }
}
