package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoByRangeOutNumber() {
        assertThatThrownBy(() -> new Money(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
