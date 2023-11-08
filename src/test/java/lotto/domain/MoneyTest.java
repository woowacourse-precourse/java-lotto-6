package lotto.domain;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class MoneyTest {

    @DisplayName("잘못된 금액이면 에러를 발생한다.")
    @Test
    void createMoneyByWrongPrice() {

        assertThatThrownBy(() -> new Money(9876))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
