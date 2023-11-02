package lotto.domain.player.playermoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HoldingMoneyTest {

    @DisplayName("보유한 금액을 저장하고, 사용한 만큼 보유 금액이 감소한 HoldingMoney 생성")
    @Test
    void holdingMoneyTest() {
        HoldingMoney holdingMoney = new HoldingMoney(10000);
        holdingMoney = holdingMoney.consumeHoldingMoney(10000);
        Assertions.assertThat(holdingMoney.getHoldingMoney()).isEqualTo(0);
    }
}
