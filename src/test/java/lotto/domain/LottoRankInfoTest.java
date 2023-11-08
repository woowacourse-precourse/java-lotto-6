package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankInfoTest {
    @Test
    @DisplayName("3개가 일치하면 FIFTH가 isBonus와 관계없이 나와야 한다.")
    void 로또_3개_일치() {
        //given
        LottoRankInfo lottoRank1 = LottoRankInfo.createLottoRank(3, false);
        LottoRankInfo lottoRank2 = LottoRankInfo.createLottoRank(3, true);
        //when
        String name1 = lottoRank1.name();
        String name2 = lottoRank2.name();
        //then
        assertThat(name1).isEqualTo("FIFTH");
        assertThat(name2).isEqualTo("FIFTH");
    }

    @Test
    @DisplayName("4개가 일치하면 isBonus와 FOURTH가 나와야 한다.")
    void 로또_4개_일치() {
        //given
        LottoRankInfo lottoRank1 = LottoRankInfo.createLottoRank(4, true);
        LottoRankInfo lottoRank2 = LottoRankInfo.createLottoRank(4, false);
        //when
        String name1 = lottoRank1.name();
        String name2 = lottoRank2.name();
        //then
        assertThat(name1).isEqualTo("FOURTH");
        assertThat(name2).isEqualTo("FOURTH");
    }

    @Test
    @DisplayName("5개가 일치하고 isBonus가 다르면 THIRD가 나온다.")
    void 로또_5개_일치_보너스는_X() {
        //given
        LottoRankInfo lottoRank = LottoRankInfo.createLottoRank(5, false);
        //when
        String name = lottoRank.name();
        //then
        assertThat(name).isEqualTo("THIRD");
    }

    @Test
    @DisplayName("5개가 일치하고 isBonus가 일치하면 SECOND 나온다.")
    void 로또_5개_일치_보너스_O() {
        //given
        LottoRankInfo lottoRank = LottoRankInfo.createLottoRank(5, true);
        //when
        String name = lottoRank.name();
        //then
        assertThat(name).isEqualTo("SECOND");
    }

    @Test
    @DisplayName("6개가 일치하면 isBonus와 상관없이 FIRST가 나온다.")
    void 로또_6개_일치_보너스_O() {
        //given
        LottoRankInfo lottoRank1 = LottoRankInfo.createLottoRank(6, false);
        LottoRankInfo lottoRank2 = LottoRankInfo.createLottoRank(6, true);
        //when
        String name1 = lottoRank1.name();
        String name2 = lottoRank2.name();
        //then
        assertThat(name1).isEqualTo("FIRST");
        assertThat(name2).isEqualTo("FIRST");
    }

    @Test
    @DisplayName("2개 이하 부터는 isBonus와 상관없이 NONE이 나온다.")
    void 로또_불일치_보너O() {
        //given
        LottoRankInfo lottoRank1 = LottoRankInfo.createLottoRank(2, false);
        LottoRankInfo lottoRank2 = LottoRankInfo.createLottoRank(2, true);
        LottoRankInfo lottoRank3 = LottoRankInfo.createLottoRank(1, false);
        LottoRankInfo lottoRank4 = LottoRankInfo.createLottoRank(1, true);
        LottoRankInfo lottoRank5 = LottoRankInfo.createLottoRank(0, false);
        LottoRankInfo lottoRank6 = LottoRankInfo.createLottoRank(0, true);
        //when
        String name1 = lottoRank1.name();
        String name2 = lottoRank2.name();
        String name3 = lottoRank3.name();
        String name4 = lottoRank4.name();
        String name5 = lottoRank5.name();
        String name6 = lottoRank6.name();

        //then
        assertThat(name1).isEqualTo("NONE");
        assertThat(name2).isEqualTo("NONE");
        assertThat(name3).isEqualTo("NONE");
        assertThat(name4).isEqualTo("NONE");
        assertThat(name5).isEqualTo("NONE");
        assertThat(name6).isEqualTo("NONE");
    }
}