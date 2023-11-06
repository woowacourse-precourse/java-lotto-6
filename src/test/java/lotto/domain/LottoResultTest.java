package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("수익률 계산")
    @Test
    void calculateEarningsRate() {
        // given
        LottoResult lottoResult = new LottoResult();
        lottoResult.state.replace(Prize.FIFTH,1);

        // when
        Double earningsRate = lottoResult.calculateEarningsRate(5);

        // then
        assertThat(earningsRate).isEqualTo(100);
    }
}