package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @DisplayName("사용자에게 로또 구입 금액을 입력 받고 로또 수량을 계산하여 사용자 객체 생성을 테스트한다.")
    @Test
    void createPlayerByValidMoney() {
        PlayerAmount playerAmount = PlayerAmount.getInstance(1000);
        Player player = Player.from(playerAmount);
        assertThat(player).isNotNull();
        assertThat(player.getPlayerAmount()).isEqualTo(1);
        assertThat(player.getPlayerLotto()).hasSize(1);
    }
}