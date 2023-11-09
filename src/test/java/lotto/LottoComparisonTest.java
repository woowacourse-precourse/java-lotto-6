package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import lotto.service.LottoComparison;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoComparisonTest {
    LottoComparison lottoComparison = new LottoComparison();

    @Test
    @DisplayName("로또 번호와 당첨번호를 비교하여 맞힌 개수를 반환한다.")
    void compareLottoWinningNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,6,7");
        long compareCount = lottoComparison.compareLottoNumbers(lotto.getNumbers(), winningNumber.getWinningNumbers());

        assertThat(compareCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호를 비교하여 번호가 있으면 true 없으면 false를 반환한다.")
    void compareLottoBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumberTrue = 5;
        int bonusNumberFalse = 10;

        boolean compareTrue = lottoComparison.compareBonusNumber(lotto.getNumbers(), bonusNumberTrue);
        boolean compareFalse = lottoComparison.compareBonusNumber(lotto.getNumbers(), bonusNumberFalse);

        assertThat(compareTrue).isEqualTo(true);
        assertThat(compareFalse).isEqualTo(false);
    }

    @Test
    @DisplayName("숫자가 6개가 다 맞았을 때 Ranking에 FIRST를 반환한다")
    void FIRSTTest() {
        long matchCount = 6;
        boolean isBonus = false;

        Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @Test
    @DisplayName("숫자가 6개가 다 맞았을 때 Ranking에 FIRST를 반환한다")
    void SECONDTest() {
        long matchCount = 5;
        boolean isBonus = true;

        Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    @DisplayName("숫자가 6개가 다 맞았을 때 Ranking에 FIRST를 반환한다")
    void THIRDTest() {
        long matchCount = 5;
        boolean isBonus = false;

        Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);

        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }

    @Test
    @DisplayName("숫자가 6개가 다 맞았을 때 Ranking에 FIRST를 반환한다")
    void FOURTHTest() {
        long matchCount = 4;
        boolean isBonus = false;

        Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);

        assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }

    @Test
    @DisplayName("숫자가 6개가 다 맞았을 때 Ranking에 FIRST를 반환한다")
    void FIFTHTest() {
        long matchCount = 3;
        boolean isBonus = false;

        Ranking ranking = lottoComparison.determineRanking(matchCount, isBonus);

        assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

}
