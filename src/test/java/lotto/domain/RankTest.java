package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("일치하는 로또 번호 개수와 보너스 일치 여부에 해당하는 당첨 Rank을 찾는다.")
    @Test
    void findRankByMatchingNumberCountAndHasMatchingBonusNumber() {
        //given
        final int matchingNumberCount = 5;
        final boolean hasMatchingBonusNumber = true;

        //when
        Rank rank = Rank.findRankBy(matchingNumberCount, hasMatchingBonusNumber);

        //then
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @DisplayName("일치하는 로또 번호 개수와 보너스 여부값에 해당하는 당첨 Rank이 존재하지 않는다.")
    @Test
    void notFindRank() {
        //given
        final int matchingNumberCount = 1;
        final boolean hasMatchingBonusNumber = true;

        //when
        Rank rank = Rank.findRankBy(matchingNumberCount, hasMatchingBonusNumber);

        //then
        assertThat(rank).isEqualByComparingTo(Rank.NONE);
    }

}