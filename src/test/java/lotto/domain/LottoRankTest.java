package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_3개일치시_FIFTH반환(boolean isBonusMatch) {
        // given
        int count = 3;
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_4개일치시_FOURTH반환(boolean isBonusMatch) {
        // given
        int count = 4;
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test()
    void findByMatchCountAndBonus_5개일치_보너스불일치시_THIRD반환() {
        // given
        int count = 5;
        boolean isBonusMatch = false;
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test()
    void findByMatchCountAndBonus_5개일치_보너스일치시_SECOND반환() {
        // given
        int count = 5;
        boolean isBonusMatch = true;
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void findByMatchCountAndBonus_6개일치시_FIRST반환(boolean isBonusMatch) {
        // given
        int count = 6;
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "0, false", "2, false"})
    void findByMatchCountAndBonus_일치하는_등수_못찾으면_NOTHING반환(int count, boolean isBonusMatch) {
        // when
        LottoRank lottoRank = LottoRank.findByMatchCountAndBonus(count, isBonusMatch);
        // then
        assertThat(lottoRank).isEqualTo(LottoRank.NOTHING);
    }

    @Test
    void totalCountOfMatchNumber는_등수별_당첨개수를_센다() {
        // given
        List<LottoRank> matchs = List.of(LottoRank.NOTHING, LottoRank.FIFTH, LottoRank.FIRST);
        // when
        List<Integer> result = LottoRank.totalCountOfMatchNumber(matchs);
        // then
        assertThat(result.get(LottoRank.FIFTH.getListIndex())).isEqualTo(1);
        assertThat(result.get(LottoRank.FOURTH.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.THIRD.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.SECOND.getListIndex())).isEqualTo(0);
        assertThat(result.get(LottoRank.FIRST.getListIndex())).isEqualTo(1);
    }

}