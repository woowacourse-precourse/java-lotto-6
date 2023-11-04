package lotto.domain.player.playermoney;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HoldingMoneyTest {

    @DisplayName("보유한 금액을 저장하고, 사용한 만큼 보유 금액이 감소한 HoldingMoney 생성")
    @Test
    void holdingMoneyTest() {
        HoldingMoney holdingMoney = new HoldingMoney(10000);
        holdingMoney = holdingMoney.consumeHoldingMoney(10000);
        assertThat(holdingMoney.getHoldingMoney()).isEqualTo(0);
    }

    @DisplayName("1000 단위가 아닌 숫자로 HoldingMoney를 생성하면 오류가 발생한다.")
    @Test
    void holdingMoneyErrorTest() {
        assertThatThrownBy(() -> new HoldingMoney(500)).isInstanceOf(IllegalArgumentException.class);
    }
}
