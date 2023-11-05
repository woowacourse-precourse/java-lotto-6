package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행() {
        // given
        int price = 8000;
        // when
        game.purchaseLotto(price);
        // then
        assertThat(game.getPurchasedLottosInfo()).contains("8개를 구매했습니다.");
    }
}
