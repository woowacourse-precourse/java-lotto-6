package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("3등 당첨 내역이 아닌 경우 false 를 반환해야함.")
    @Test
    void THIRD_LANK_당첨_내역_확인_테스트() {
        LottoResult lottoResult = new LottoResult(LottoRank.FIRST_RANK, 3);
        assertThat(lottoResult.isLottoSecondRank()).isFalse();
    }

}