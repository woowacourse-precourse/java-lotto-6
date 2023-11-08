package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("플레이어가 1000원 단위로 로또를 구매하는 기능 테스트")
    @Test
    public void testBuy() {
        Player player = new Player();
        player.buy(17000);

        List<Lotto> lottos = player.getLottos();
        assertEquals(17, lottos.size());
    }

    @DisplayName("플레이어가 자신의 로또를 기준으로 당첨 통계를 계산하는 기능 테스트")
    @Test
    public void testCalculateResult() {
        Player player = new Player();
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> playerLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        player.getLottos().addAll(playerLottos);

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        WinningResult result = player.calculateResult(winningNumbers);

        assertNotNull(result);
        assertEquals(1, result.winningStatistics().get(Rank.FIRST));
        assertEquals(1, result.winningStatistics().get(Rank.SECOND));
        assertEquals(0, result.winningStatistics().get(Rank.THIRD));
        assertEquals(0, result.winningStatistics().get(Rank.FOURTH));
        assertEquals(0, result.winningStatistics().get(Rank.FIFTH));
        assertEquals(1, result.winningStatistics().get(Rank.NOTHING));
    }
}
