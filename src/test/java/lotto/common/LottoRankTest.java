package lotto.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("일치하는 번호가 없으면 순위 없음을 반환한다.")
    @Test
    void 일치하는_번호가_없으면_순위없음을_반환한다() {
        int matchedNumber = 0;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, false);

        assertThat(lottoRank).isEqualTo(LottoRank.NO_RANK);
    }

    @DisplayName("번호가 3개 일치하고 보너스가 일치하지 않으면 5등을 반환한다")
    @Test
    void 번호가_3개일치하면_5등을_반환한다() {
        int matchedNumber = 3;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH_RANK);
    }

    @DisplayName("번호가 4개 일치하고 보너스가 일치하지 않으면 4등을 반환한다")
    @Test
    void 번호가_4개일치하면_4등을_반환한다() {
        int matchedNumber = 4;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH_RANK);
    }

    @DisplayName("번호가 5개 일치하고 보너스가 일치하지 않으면 3등을 반환한다")
    @Test
    void 번호가_5개일치하면_3등을_반환한다() {
        int matchedNumber = 5;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, false);

        assertThat(lottoRank).isEqualTo(LottoRank.THIRD_RANK);
    }

    @DisplayName("번호가 5개 일치하고 보너스가 일치하면 2등을 반환한다")
    @Test
    void 번호가_5개일치하고_보너스가_일치하면_2등을_반환한다() {
        int matchedNumber = 5;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, true);

        assertThat(lottoRank).isEqualTo(LottoRank.SECOND_RANK);
    }

    @DisplayName("번호가 6개 일치하고 보너스가 일치하지 않으면 1등을 반환한다")
    @Test
    void 번호가_6개일치하면_1등을_반환한다() {
        int matchedNumber = 6;
        LottoRank lottoRank = LottoRank.getRankByMatchedNumbers(matchedNumber, false);

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST_RANK);
    }

}
