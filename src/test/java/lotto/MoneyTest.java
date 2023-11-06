package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈 정상값 테스트.")
    @Test
    void createMoneyByNormal() {
        assertThat(new Money(1000).getMoney()).isEqualTo(1000);
    }

    @DisplayName("돈 에외 테스트.")
    @Test
    void createMoneyByNoMoney() {
        Assertions.assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}