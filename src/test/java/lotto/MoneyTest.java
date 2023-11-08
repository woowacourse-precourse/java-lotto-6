package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import lotto.Domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("입력한 구매 금액이 1,000원 단위가 아니면 예외처리를 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Money(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}