package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("LottoResult 각 상수에 대해 prize 확인")
    @Test
    void lottoGetPrizeTest() {
        assertThat(LottoResult.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(LottoResult.SECOND.getPrize()).isEqualTo(30000000);
        assertThat(LottoResult.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(LottoResult.FORTH.getPrize()).isEqualTo(50000);
        assertThat(LottoResult.FIFTH.getPrize()).isEqualTo(5000);
        assertThat(LottoResult.FAIL.getPrize()).isEqualTo(0);
    }

    @Test
    void lottoGetDescriptionTest() {
        assertThat(LottoResult.FIRST.getDescription()).isEqualTo(2000000000);
        assertThat(LottoResult.SECOND.getDescription()).isEqualTo(30000000);
        assertThat(LottoResult.THIRD.getDescription()).isEqualTo(1500000);
        assertThat(LottoResult.FORTH.getDescription()).isEqualTo(50000);
        assertThat(LottoResult.FIFTH.getDescription()).isEqualTo(5000);
        assertThat(LottoResult.FAIL.getDescription()).isEqualTo(0);
    }
}