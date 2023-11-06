package lotto.service;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.RankGroup;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;
    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void getLottos() {

    }

    @Test
    void generateLottos() {
        lottoService.generateLottos(5);
        assertEquals(5, lottoService.getLottos().size());
    }

    @Test
    void aggregateLotto() {

        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(firstRankLotto);
        myLotto.add(secondRankLotto);

        Lotto winningLotto = lottoService.pickWinningLotto("1, 2, 3, 4, 5, 6");
        int bonusNumber = lottoService.pickBonusNumber("7");
        lottoService.aggregateLotto(myLotto, winningLotto, bonusNumber);

        assertEquals(1, RankGroup.FIRST.getResult(), "1등 로또 수가 예상값과 일치해야 합니다.");
        assertEquals(1, RankGroup.SECOND.getResult(), "2등 로또 수가 예상값과 일치해야 합니다.");
        assertEquals(0, RankGroup.THIRD.getResult(), "3등 로또 수가 예상값과 일치해야 합니다.");
        assertEquals(0, RankGroup.FOURTH.getResult(), "4등 로또 수가 예상값과 일치해야 합니다.");
        assertEquals(0, RankGroup.FIFTH.getResult(), "5등 로또 수가 예상값과 일치해야 합니다.");
    }

    @Test
    void pickWinningLotto() {
        lottoService.pickWinningLotto("1,2,3,4,5,6");
        assertNotNull(WinningLotto.getInstance().getWinningLotto());
    }

    @Test
    void pickBonusNumber() {
        lottoService.pickBonusNumber("7");
        assertEquals(7, WinningLotto.getInstance().getBonusNumber());
    }

    @Test
    void countProfitRate() {
        int trial = 50;
        float actualProfitRate = lottoService.countProfitRate(trial);
        float expectedProfitRate = (float) RankGroup.getTotalReward() / (trial * BASE_LOTTO_PRICE) * 100;
        assertEquals(expectedProfitRate, actualProfitRate);
    }
}
