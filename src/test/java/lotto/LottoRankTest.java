package lotto;

import lotto.globalconstatnt.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("로또번호가 1개 일치한 경우")
    void getLottoRank_1개일치() {
        long matchCount = 1L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.NO_RANK);
        assertThat(lottoRank).isEqualTo(LottoRank.NO_RANK);
    }

    @Test
    @DisplayName("로또번호가 2개 일치한 경우")
    void getLottoRank_2개일치() {
        long matchCount = 2L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.NO_RANK);
        assertThat(lottoRank).isEqualTo(LottoRank.NO_RANK);
    }

    @Test
    @DisplayName("로또번호가 3개 일치한 경우")
    void getLottoRank_3개일치() {
        long matchCount = 3L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.FIFTH);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또번호가 4개 일치한 경우")
    void getLottoRank_4개일치() {
        long matchCount = 4L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.FOURTH);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또번호가 5개 일치한 경우, 5개 일치 보너스번호 일치한 경우")
    void getLottoRank_5개일치() {
        long matchCount = 5L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.SECOND);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또번호가 6개 일치한 경우")
    void getLottoRank_6개일치() {
        long matchCount = 6L;
        LottoRank lottoRankMatchBonusNumber = LottoRank.getLottoRank(matchCount,true);
        LottoRank lottoRank = LottoRank.getLottoRank(matchCount,false);

        assertThat(lottoRankMatchBonusNumber).isEqualTo(LottoRank.FIRST);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }


}