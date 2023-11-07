package lotto;

import model.Lotto;
import model.LottoGame;
import model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
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
                new Lotto("3,42,23,18,37,28"), // 1개
                new Lotto("3,8,9,13,27,11"), // 5개+보너스볼 일치
                new Lotto("3,6,8,5,13,26"), // 3개 일치
                new Lotto("3,8,9,6,10,45"), // 3개 일치
                new Lotto ("1,2,9,13,27,35"))); // 4개일치
        WinningLotto winningLotto = new WinningLotto("3,8,9,13,27,35","11");
        Map<Integer, Integer> answer = Map.of(7,0,6,1,5,0,4,1,3,2);
        assertEquals(answer, lottoGame.countWinningLottoResult(winningLotto));
    }
}