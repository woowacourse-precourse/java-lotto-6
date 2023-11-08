package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 매치된번호개수가_6개라면_1등당첨이다(){
        //when
        Rank findRank1 = Rank.findRankByMatchedNBonusNumber(6, false);
        Rank findRank2 = Rank.findRankByMatchedNBonusNumber(6, true);
        //then
        Assertions.assertThat(findRank1).isEqualTo(Rank.FIRST_PLACE);
        Assertions.assertThat(findRank2).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    void 매치된번호개수가_5개이고_보너스번호가_존재하면_2등당첨이다(){
        //when
        Rank findRank = Rank.findRankByMatchedNBonusNumber(5, true);
        //then
        Assertions.assertThat(findRank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    void 매치된번호개수가_5개이고_보너스번호가_존재하지않으면_3등당첨이다(){
        //when
        Rank findRank = Rank.findRankByMatchedNBonusNumber(5, false);
        //then
        Assertions.assertThat(findRank).isEqualTo(Rank.THIRD_PLACE);
    }

    @Test
    void 매치된번호개수가_4개라면_4등당첨이다(){
        //when
        Rank findRank1 = Rank.findRankByMatchedNBonusNumber(4, false);
        Rank findRank2 = Rank.findRankByMatchedNBonusNumber(4, true);
        //then
        Assertions.assertThat(findRank1).isEqualTo(Rank.FOURTH_PLACE);
        Assertions.assertThat(findRank2).isEqualTo(Rank.FOURTH_PLACE);
    }

    @Test
    void 매치된번호개수가_3개라면_5등당첨이다(){
        //when
        Rank findRank1 = Rank.findRankByMatchedNBonusNumber(3, false);
        Rank findRank2 = Rank.findRankByMatchedNBonusNumber(3, true);
        //then
        Assertions.assertThat(findRank1).isEqualTo(Rank.FIFTH_PLACE);
        Assertions.assertThat(findRank2).isEqualTo(Rank.FIFTH_PLACE);
    }

    @Test
    void 매치된번호개수가_2개이하라면_꽝이다(){
        //when
        Rank findRank1 = Rank.findRankByMatchedNBonusNumber(2, false);
        Rank findRank2 = Rank.findRankByMatchedNBonusNumber(2, true);
        Rank findRank3 = Rank.findRankByMatchedNBonusNumber(1, false);
        Rank findRank4 = Rank.findRankByMatchedNBonusNumber(1, true);
        Rank findRank5 = Rank.findRankByMatchedNBonusNumber(0, false);
        Rank findRank6 = Rank.findRankByMatchedNBonusNumber(0, true);
        //then
        Assertions.assertThat(findRank1).isEqualTo(Rank.NOTHING);
        Assertions.assertThat(findRank2).isEqualTo(Rank.NOTHING);
        Assertions.assertThat(findRank2).isEqualTo(Rank.NOTHING);
        Assertions.assertThat(findRank2).isEqualTo(Rank.NOTHING);
        Assertions.assertThat(findRank2).isEqualTo(Rank.NOTHING);
        Assertions.assertThat(findRank2).isEqualTo(Rank.NOTHING);
    }
}