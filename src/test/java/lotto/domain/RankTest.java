package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 6개 일치")
    @Test
    void findByMatchedCountAndBonusNumberMatchedWhenSixMatched() {
        Rank sixMatched = Rank.findByMatchedCountAndBonusNumberMatched(6, false);

        Assertions.assertThat(sixMatched).isEqualTo(Rank.SIX_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 5개, 보너스볼 일치")
    @Test
    void findByMatchedCountAndBonusNumberMatchedWhenFiveAndBonusNumberMatched() {

        Rank fiveAndBonusNumberMatched = Rank.findByMatchedCountAndBonusNumberMatched(5, true);

        Assertions.assertThat(fiveAndBonusNumberMatched).isEqualTo(Rank.FIVE_AND_BONUS_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 5개, 보너스볼 불일치")
    @Test
    void findByMatchedCountAndBonusNumberMatchedWhenFiveMatched() {
        Rank fiveMatched = Rank.findByMatchedCountAndBonusNumberMatched(5, false);

        Assertions.assertThat(fiveMatched).isEqualTo(Rank.FIVE_MATCH);
    }
}