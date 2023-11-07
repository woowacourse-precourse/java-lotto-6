package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 6개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenSixMatched() {
        Rank sixMatched = Rank.decideByMatchedCountAndBonusNumberMatched(6, false);

        assertThat(sixMatched).isEqualTo(Rank.SIX_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 5개, 보너스볼 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenFiveAndBonusNumberMatched() {

        Rank fiveAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(5, true);

        assertThat(fiveAndBonusNumberMatched).isEqualTo(Rank.FIVE_AND_BONUS_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 5개, 보너스볼 불일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenFiveMatched() {
        Rank fiveMatched = Rank.decideByMatchedCountAndBonusNumberMatched(5, false);

        assertThat(fiveMatched).isEqualTo(Rank.FIVE_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 4개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenFourMatched() {
        Rank fourMatched = Rank.decideByMatchedCountAndBonusNumberMatched(4, false);
        Rank fourAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(4, true);

        assertThat(fourMatched).isEqualTo(Rank.FOUR_MATCH);
        assertThat(fourAndBonusNumberMatched).isEqualTo(Rank.FOUR_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 3개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenThreeMatched() {
        Rank threeMatched = Rank.decideByMatchedCountAndBonusNumberMatched(3, false);
        Rank threeAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(3, true);

        assertThat(threeMatched).isEqualTo(Rank.THREE_MATCH);
        assertThat(threeAndBonusNumberMatched).isEqualTo(Rank.THREE_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 2개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenTwoMatched() {
        Rank twoMatched = Rank.decideByMatchedCountAndBonusNumberMatched(2, false);
        Rank twoAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(2, true);

        assertThat(twoMatched).isEqualTo(Rank.TWO_MATCH);
        assertThat(twoAndBonusNumberMatched).isEqualTo(Rank.TWO_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 1개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenOneMatched() {
        Rank oneMatched = Rank.decideByMatchedCountAndBonusNumberMatched(1, false);
        Rank oneAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(1, true);

        assertThat(oneMatched).isEqualTo(Rank.ONE_MATCH);
        assertThat(oneAndBonusNumberMatched).isEqualTo(Rank.ONE_MATCH);
    }

    @DisplayName("일치한 번호와 보너스볼 매치 여부를 통해 당첨 결과를 결정한다. - 0개 일치")
    @Test
    void decideByMatchedCountAndBonusNumberMatchedWhenZeroMatched() {
        Rank zeroMatched = Rank.decideByMatchedCountAndBonusNumberMatched(0, false);
        Rank zeroAndBonusNumberMatched = Rank.decideByMatchedCountAndBonusNumberMatched(0, true);

        assertThat(zeroMatched).isEqualTo(Rank.ZERO_MATCH);
        assertThat(zeroAndBonusNumberMatched).isEqualTo(Rank.ZERO_MATCH);
    }
}