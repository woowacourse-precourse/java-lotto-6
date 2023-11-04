package lotto.domain.player;

import lotto.domain.common.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerMoneyTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        PlayerMoney playerMoney = PlayerMoney.from(Money.from(10000));
    }

    @DisplayName("알 수 없는 금액으로 사용자 소지금을 생성할 수 없다.")
    @Test
    void checkMoneyNonNull() {
        assertThatThrownBy(() -> PlayerMoney.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 금액입니다.");
    }

    @DisplayName("알 수 없는 총 수익금과 수익률을 계산할 수 없다.")
    @Test
    void checkMoneyNonNullAtCalculation() {
        PlayerMoney playerMoney = PlayerMoney.from(Money.from(1000));

        assertThatThrownBy(() -> playerMoney.calculateEarningRate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 금액입니다.");
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calculateEarningRate() {
        PlayerMoney playerMoney = PlayerMoney.from(Money.from(8000));

        double result = playerMoney.calculateEarningRate(Money.from(5000));

        assertThat(result).isEqualTo(62.5);
    }
}
