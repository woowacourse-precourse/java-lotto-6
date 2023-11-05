package lotto.domain;

import lotto.domain.lotto.LottoGame;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningNumbers;
import lotto.global.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class LottoGameTest {

    Lottos lottos;
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(3,new FakeNumberGenerator());
        lottoGame = new LottoGame(lottos, new WinningNumbers());

        lottoGame.generateWinningNumbers("1,2,3,4,5,6","7");
    }

    @Test
    void test() {
        Map<LottoRank, Integer> map = lottoGame.calculateLottoResults();

        for (LottoRank lottoRank : map.keySet()) {
            Integer result = map.getOrDefault(lottoRank, 0);

            System.out.println(lottoRank.getMessage() + result);
        }
    }
}
