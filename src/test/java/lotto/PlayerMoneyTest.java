package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.PlayerMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerMoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "1100"})
    @DisplayName("사용자 금액 오류")
    void WrongPlayerMoney(String money) {
        assertThatThrownBy(() -> new PlayerMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 티켓 수 확인")
    void calculateLottoCount() {
        PlayerMoney playerMoney = new PlayerMoney("15000");
        assertThat(playerMoney.getNumOfLottoBuy()).isEqualTo(15);
    }
}
