package lotto.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("당첨 번호 5개만 맞을 경우 3등으로 선정된다.")
    @Test
    void calculateRankWithMatchingNumbersAndNoBonus() {
        // given
        int countWinning = 5;
        boolean matchBonusNum = false;

        // when
        Rank rank = Rank.calculate(countWinning, matchBonusNum);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getMatchLottoNumber()).isEqualTo(5);
        assertThat(rank.getPrizeAmount()).isEqualTo(1_500_000);
    }

    @DisplayName("당첨 번호 5개, 보너스 번호 1개가 맞을 경우 2등으로 선정된다.")
    @Test
    void calculateRankWithMatchingNumbersAndBonus() {
        // given
        int countWinning = 5;
        boolean matchBonusNum = true;

        // when
        Rank rank = Rank.calculate(countWinning, matchBonusNum);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getMatchLottoNumber()).isEqualTo(5);
        assertThat(rank.getPrizeAmount()).isEqualTo(30_000_000);
    }

    @DisplayName("당첨 번호 2개, 보너스 번호 1개가 맞을 경우 등수에 포함되지 않는다.")
    @Test
    void calculateRankWithNoMatchingNumbers() {
        // given
        int countWinning = 2;
        boolean matchBonusNum = true;

        // when
        Rank rank = Rank.calculate(countWinning, matchBonusNum);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getMatchLottoNumber()).isEqualTo(0);
        assertThat(rank.getPrizeAmount()).isEqualTo(0);
    }

    @DisplayName("당첨 번호 1개만 맞을 경우 등수에 포함되지 않는다.")
    @Test
    void calculateRankWithInvalidMatchingNumbers() {
        // given
        int countWinning = 1;
        boolean matchBonusNum = false;

        // when
        Rank rank = Rank.calculate(countWinning, matchBonusNum);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getMatchLottoNumber()).isEqualTo(0);
        assertThat(rank.getPrizeAmount()).isEqualTo(0);
    }
}
