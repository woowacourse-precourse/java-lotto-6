package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("1000으로 나누어 떨어지지 않는 금액일 경우 예외처리한다.")
    @Test
    void createMoneyNotDivideThousand() {
        assertThatThrownBy(() -> new Money(6555))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
