package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame game = new LottoGame();

    @DisplayName("구입금액만큼 로또를 발행한다.")
    @Test
    void 로또발행() {
        game.setLottoPurchaseAmount("10000");
        game.createLottoTickets();
        assertThat(game.getPurchasedLottos().size()).isEqualTo(10);
    }

    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 로또미발행() {
        assertThatThrownBy(() -> game.setLottoPurchaseAmount("8550"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}