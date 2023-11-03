package lotto.domain.player.playermoney;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerWalletTest {
    private PlayerWallet playerWallet;

    @BeforeEach
    void initGivenCondition() {
        playerWallet = new PlayerWallet(10000);

    }

    @DisplayName("PlayerMoney 에서 초기화한 만큼의 돈을 consumeMoneyToLottoTicket() 으로 사용하면 usedMoney 로 사용한 금액을 받을 수 있다.")
    @Test
    void playerMoneyTest_1() {
        //when
        playerWallet.consumeMoneyToLottoTicket(10000);
        //then
        assertThat(playerWallet.getUsedMoney()).isEqualTo(10000);
    }

    @DisplayName("PlayerMoney 에서 holdingMoney 를 getHoldingMoney() 를 통해 받을 수 있다.")
    @Test
    void playerMoneyTest_2() {
        assertThat(playerWallet.getHoldingMoney()).isEqualTo(10000);
    }
}
