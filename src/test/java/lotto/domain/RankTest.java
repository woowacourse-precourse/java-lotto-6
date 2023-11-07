package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    public void 일등_당첨_테스트() {
        // given
        int matchCount = 6;
        boolean matchBonus = false;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 이등_당첨_테스트() {
        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    public void 삼등_당첨_테스트() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 사등_당첨_테스트() {
        // given
        int matchCount = 4;
        boolean matchBonus = false;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    public void 오등_당첨_테스트() {
        // given
        int matchCount = 3;
        boolean matchBonus = false;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void 낙첨_테스트() {
        // given
        int matchCount = 0;
        boolean matchBonus = false;

        // when
        Rank result = Rank.checkWinningStatus(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Rank.NO_LUCK);
    }

}