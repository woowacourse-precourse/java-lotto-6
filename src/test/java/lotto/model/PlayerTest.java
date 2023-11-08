package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.model.domain.Player;
import lotto.model.handler.GameHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("로또 구매 기능 테스트")
    @Test
    void purchaseLotto() {
        Player player = new Player();
        player.purchaseLotto(5000);

        assertThat(player.getLottos().size()).isEqualTo(5);
        assertThat(player.getPurchaseCost()).isEqualTo(5000);
    }
}
