package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCompareTest {
    @DisplayName("6개 일치")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void lottoCompare_6개_일치(boolean isIncludeBonusNumbers) {
        int match = 6;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.FIRST);
    }

    @DisplayName("5개 일치, 보너스 번호 일치")
    @Test
    void lottoCompare_5개_일치_보너스번호_일치() {
        int match = 5;
        boolean isIncludeBonusNumbers = true;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.SECOND);
    }

    @DisplayName("5개 일치, 보너스 번호 불일치")
    @Test
    void lottoCompare_5개_일치_보너스번호_불일치() {
        int match = 5;
        boolean isIncludeBonusNumbers = false;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.THIRD);
    }

    @DisplayName("4개 일치")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void lottoCompare_4개_일치(boolean isIncludeBonusNumbers) {
        int match = 4;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.FOURTH);
    }

    @DisplayName("3개 일치")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void lottoCompare_3개_일치(boolean isIncludeBonusNumbers) {
        int match = 3;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.FIFTH);
    }

    @DisplayName("순위권 밖")
    @ParameterizedTest
    @ValueSource(ints = {2,1,0})
    void lottoCompare_2개_일치(int match) {
        boolean isIncludeBonusNumbers = true;
        assertThat(LottoCompare.getCompareResult(match, isIncludeBonusNumbers)).isEqualByComparingTo(LottoCompare.NONE);
    }
}
