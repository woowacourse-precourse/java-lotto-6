package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultCalculatorTest {
    private WinningLotto winningLotto;

    @BeforeEach()
    void setUp() {
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.setBonusNumber(7);
    }

    @Test()
    void 번호가_6개_일치하면_1등이다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.FIRST)).isEqualTo(1);
    }

    @Test()
    void 번호가_5개_일치하고_보너스_번호가_일치하면_2등이다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test()
    void 번호가_5개_일치하고_보너스_번호가_일치하지_않으면_3등이다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.THIRD)).isEqualTo(1);
    }

    @Test()
    void 번호가_4개_일치하면_4등이다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test()
    void 번호가_3개_일치하면_5등이다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test()
    void 번호가_2개_이하로_일치하면_당첨이_아니다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        assertThat(resultCalculator.getResult().get(Rank.OUT_OF_RANKS)).isEqualTo(1);
    }

    @Test()
    void 구매한_로또_번호와_당첨_번호를_비교하여_수익률을_구한다() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        ResultCalculator resultCalculator = new ResultCalculator();
        resultCalculator.calculateWinningCounts(lottos, winningLotto);

        resultCalculator.calculateProfitRate(8000);

        assertThat(resultCalculator.getProfitRate()).isEqualTo(62.5);
    }
}