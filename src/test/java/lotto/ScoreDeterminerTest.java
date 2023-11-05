package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.ScoreDeterminer;
import lotto.utils.StringChanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreDeterminerTest {
    @DisplayName("1등 판별 테스트")
    @Test
    void getFirstTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.SIX_MATCH);
    }

    @DisplayName("2등 판별 테스트")
    @Test
    void getSecondTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.FIVE_AND_BONUS_MATCH);
    }

    @DisplayName("3등 판별 테스트")
    @Test
    void getThirdTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.FIVE_MATCH);
    }

    @DisplayName("4등 판별 테스트")
    @Test
    void getFourthTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 45));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.FOUR_MATCH);
    }

    @DisplayName("5등 판별 테스트")
    @Test
    void getFifthTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.THREE_MATCH);
    }

    @DisplayName("등수 없음 판별 테스트")
    @Test
    void getNoRankTest() {
        String firstNumbersInput = "1,2,3,4,5,6";
        String bonusNumberInput = "7";
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 38));

        Rank rank = getRankByComparing(firstNumbersInput, bonusNumberInput, lotto);

        assertThat(rank).isEqualTo(Rank.NO_RANK);
    }

    private Rank getRankByComparing(String firstNumberInput, String bonusNumberInput, Lotto lotto) {
        List<String> firstNumbers = StringChanger.toTrimmedStringList(firstNumberInput);

        ScoreDeterminer scoreDeterminer = new ScoreDeterminer();
        scoreDeterminer.setFirstRankNumbers(firstNumbers);
        scoreDeterminer.setBonusNumber(bonusNumberInput);

        return scoreDeterminer.getRank(lotto);
    }
}
