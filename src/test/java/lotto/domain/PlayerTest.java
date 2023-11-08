package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setup() {
        player = new Player(3000);
    }

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    void testInvalidPurchaseAmount() {
        assertThrows(IllegalArgumentException.class, () -> new Player(1500));
    }

    @Test
    @DisplayName("로또를 구매한다.")
    void testBuyLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        player.buyLotto(lotto);
        assertThat(player.getLottos()).contains(lotto);
    }

    @Test
    @DisplayName("당첨 결과를 올바르게 계산한다.")
    void testCalculateResult() {
        // Given
        player.buyLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When
        LottoResult result = player.calculateResult(winningNumbers, bonusNumber);

        // Then
        assertThat(result.getTotalPrize()).isPositive();
        assertThat(result.getProfitRate()).isGreaterThan(0);
    }
}
