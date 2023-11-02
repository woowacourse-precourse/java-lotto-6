package lotto.domain.player.playermoney;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerMoneyTest {

    @DisplayName("PlayerMoney 에서 초기화한 만큼의 돈을 consumeMoneyToLottoTicket() 에 사용하면 usedMoney 로 그 금액을 받을 수 있다.")
    @Test
    void playerMoneyTest() {
        PlayerMoney playerMoney = new PlayerMoney(10000);
        playerMoney.consumeMoneyToLottoTicket(10000);
        Assertions.assertThat(playerMoney.getUsedMoney()).isEqualTo(10000);
    }
}
