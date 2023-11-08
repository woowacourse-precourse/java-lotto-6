package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    @Test
    void canCountWinningLottoResult() throws IllegalAccessException, NoSuchFieldException {
        LottoGame lottoGame = new LottoGame();
        Field lottos = LottoGame.class.getDeclaredField("lottos");
        lottos.setAccessible(true);
        lottos.set(lottoGame, List.of(
                new Lotto("3,42,23,18,37,28"),
                new Lotto("3,8,9,13,27,11"),
                new Lotto("3,6,8,5,13,26"),
                new Lotto("3,8,9,6,10,45"),
                new Lotto ("1,2,9,13,27,35")));
        WinningLotto winningLotto = new WinningLotto("3,8,9,13,27,35","11");
        Map<Integer, Integer> answer = Map.of(7,0,6,1,5,0,4,1,3,2);
        assertEquals(answer, lottoGame.countWinningLottoResult(winningLotto));
    }

    @Test
    void canCalculateEarnings() {
        LottoGame lottoGame = new LottoGame();
        Map<Integer, Integer> gameResult = Map.of(7,1,6,2,5,1,4,3,3,2);
        long answer = 2061660000;
        assertEquals(lottoGame.calculateEarnings(gameResult), answer);
    }
}