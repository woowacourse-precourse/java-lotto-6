package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void moneyIsNumber() {
        assertThatThrownBy(() -> new Money("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
