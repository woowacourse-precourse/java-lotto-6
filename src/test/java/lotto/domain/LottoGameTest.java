package lotto.domain;

import lotto.domain.game.LottoGame;
import lotto.domain.lotto.*;
import lotto.global.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    Lottos lottos;
    LottoGame lottoGame;
    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(3,new FakeNumberGenerator());
        lottoGame = new LottoGame();

        winningNumbers = new WinningNumbers(new WinningNormalNumbers() ,new BonusNumber());
        winningNumbers.generateWinningNormalNumbers("1,2,3,4,5,6");
        winningNumbers.generateBonusNumber("7");

    }

    @Test
    void LottoGame이_결과를_잘_배출하는지_확인() {
        LottoRank expected = LottoRank.FIRST_PLACE;

        Map<LottoRank, Integer> map = lottoGame.calculateLottoResults(lottos, winningNumbers);

        for (LottoRank lottoRank : map.keySet()) {
            Integer result = map.getOrDefault(lottoRank, 0);

            System.out.println(result);
        }

        assertThat(map.get(expected))
                .isEqualTo(3);
    }
}
