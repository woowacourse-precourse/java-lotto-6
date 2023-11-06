package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerLottoTest {
    @Test
    @DisplayName("입력된 수만큼 로또가 발행되어야한다.")
    void publish() {
        int quantity = 3;
        PlayerLotto playerLotto = new PlayerLotto();
        playerLotto.publish(quantity);

        Assertions.assertThat(playerLotto.getQuantity() == quantity).isTrue();
    }
}