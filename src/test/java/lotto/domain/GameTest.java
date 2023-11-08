package lotto.domain;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    List<Lotto> lottos;
    WinningLotto winningLotto;
    Game game;
    @BeforeEach
    public void init() {
        this.lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto (List.of(1, 3, 5, 14, 22, 45)));
        this.winningLotto = new WinningLotto(List.of(1, 3, 5, 14, 22, 40), 41);
        this.game = new Game(lottos, winningLotto);
    }

    @DisplayName("3등 당첨 갯수가 1개일 때")
    @Test
    public void testRun() {
        assertThat(game.run().get(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("3등 당첨 갯수가 1개일 때 수익률")
    @Test
    public void testGetEarningRate() {
        Map<Rank, Integer> result = game.run();
        assertThat(game.getEarningRate(result, 3000)).isEqualTo(50000.0d);
    }
}
