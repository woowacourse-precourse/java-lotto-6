package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoScoreCheckerTest {
    @DisplayName("1등 로또와 비교하여 맞춘 갯수 확인")
    @Test
    void checkMatchingFirstNumbers() {
        String firstNumbers = "1,2,3,4,5,6";
        LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
        lottoScoreChecker.setFirstNumbers(firstNumbers);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoScoreChecker.compareToFirstRankNumber(lotto)).isEqualTo(6);
    }

    @DisplayName("보너스 번호와 비교하여 있는지 확인")
    @Test
    void checkMatchingBonusNumber() {
        String firstNumbers = "1,2,3,4,5,6";
        LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
        lottoScoreChecker.setFirstNumbers(firstNumbers);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        String bonusNumbers = "7";
        lottoScoreChecker.setBonusNumber(bonusNumbers);
        assertThat(lottoScoreChecker.compareToBonusNumber(lotto)).isEqualTo(true);
    }

    @DisplayName("getRankTest")
    @Test
    void getRankTest() {
        String firstNumbers = "1,2,3,4,5,6";
        LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
        lottoScoreChecker.setFirstNumbers(firstNumbers);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));
        String bonusNumbers = "7";
        lottoScoreChecker.setBonusNumber(bonusNumbers);
        assertThat(lottoScoreChecker.getRank(lotto)).isEqualTo(Rank.FIVE_AND_BONUS_MATCH);
    }
}
