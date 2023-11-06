package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("2등 당첨 내역인 경우 true, 아닌 경우 false 를 반환 해야한다.")
    @Test
    void SECOND_LANK_당첨_내역_확인_테스트() {
        LottoResult firstResult = new LottoResult(LottoRank.FIRST_RANK, 3);
        LottoResult secondResult = new LottoResult(LottoRank.SECOND_RANK, 3);
        assertThat(firstResult.isLottoSecondRank()).isFalse();
        assertThat(secondResult.isLottoSecondRank()).isTrue();
    }

}