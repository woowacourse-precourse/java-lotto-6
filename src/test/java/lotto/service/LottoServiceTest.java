package lotto.service;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.DIGIT;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.RankGroup;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;
    WinningLotto winningLottoclass;

    @BeforeEach
    void setUp() {
        winningLottoclass = WinningLotto.getInstance();
        lottoService = new LottoService(winningLottoclass);
    }

    @DisplayName("구입한 로또 개수 확인")
    @Test
    void generateLottos() {
        List<Lotto> lottos = lottoService.generateLottos(10);
        assertEquals(10, lottos.size());
    }

    @DisplayName("구입한 로또와 당첨 번호 결과가 맞아야한다.")
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

    @DisplayName("정상적으로 로또 번호를 택한다.")
    @Test
    void pickWinningLotto() {
        lottoService.pickWinningLotto("1,2,3,4,5,6");
        assertNotNull(WinningLotto.getInstance().getWinningLotto());
    }

    @DisplayName("정상적으로 보너스 번호를 택한다.")
    @Test
    void pickBonusNumber() {
        lottoService.pickBonusNumber("7");
        assertEquals(7, WinningLotto.getInstance().getBonusNumber());
    }

    @DisplayName("정상적으로 수익률을 리턴한다.")
    @Test
    void countProfitRate() {
        int trial = 50;
        BigDecimal actualProfitRate = lottoService.countProfitRate(trial);
        BigDecimal expectedProfitRate = BigDecimal.valueOf(RankGroup.getTotalReward())
                .divide(BigDecimal.valueOf(trial * BASE_LOTTO_PRICE), DIGIT+2, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(100));
        assertEquals(expectedProfitRate, actualProfitRate);
    }
}
