package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("1,000원 미만의 금액을 입력하면 예외가 발생한다.")
    @Test
    void createMoneyByNotEnoughMoney() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원 단위가 아닌 금액을 입력하면 예외가 발생한다.")
    @Test
    void createMoneyByNotMultipleOfThousand() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 정상")
    @Test
    void createMoney() {
        assertDoesNotThrow(() -> new Money(8000));
    }

    @DisplayName("로또 개수 반환")
    @Test
    void ticketCount() {
        //given
        Money money = new Money(8000);

        //when
        int ticketCount = money.ticketCount();

        //then
        assertThat(ticketCount).isEqualTo(8);
    }

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningsRate() {
        //given
        Money money = new Money(8000);
        int totalWinningAmount = 5000;

        //when
        float earningsRate = money.calculateEarningsRate(totalWinningAmount);

        //then
        float expected = (float) 5000 / 8000 * 100;
        assertThat(earningsRate).isEqualTo(expected);
    }
}