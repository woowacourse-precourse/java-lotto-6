package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("로또 구입 금액이 1,000원 보다 작으면 예외가 발생한다.")
    @Test
    void createPlayerByUnderMinimumPurchaseAmount() {
        assertThatThrownBy(() -> new Player(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPlayerByNotDivide1000() {
        assertThatThrownBy(() -> new Player(10100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calculateReteOfReturn() {
        Player player = new Player(8000);
        int totalPrizeMoney = 5000;

        double rateOfReturn = player.calculateRateOfReturn(totalPrizeMoney);

        Assertions.assertThat(rateOfReturn).isEqualTo(62.5);
    }
}
