package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_6개이면_1등입니다() {
        // given
        final int matchingNumber = 6;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FIRST);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_5개이면서_보너스_번호도_일치하면_2등입니다() {
        // given
        final int matchingNumber = 5;
        final boolean bonusMatch = true;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.SECOND);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_5개이면서_보너스_번호가_일치하지_않으면_3등입니다() {
        // given
        final int matchingNumber = 5;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.THIRD);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_4개이면_4등입니다() {
        // given
        final int matchingNumber = 4;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FOURTH);
    }

    @Test
    public void 당첨_번호와_로또_번호가_일치하는_개수가_3개이면_5등입니다() {
        // given
        final int matchingNumber = 3;
        final boolean bonusMatch = false;

        // when
        final Rank firstRank = Rank.find(matchingNumber, bonusMatch);

        // then
        Assertions.assertEquals(firstRank, Rank.FIFTH);
    }
}