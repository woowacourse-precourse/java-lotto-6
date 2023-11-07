package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    List<LottoRank> rank;

    @BeforeEach
    void setUp(){
        // given
        List<LottoRank> rank = Arrays.asList(LottoRank.FAIL, LottoRank.FIFTH, LottoRank.FOURTH);
    }

    @DisplayName("[SUCCESS]구매한 모든 로또에 대한 당첨 금액 합계를 계산한다.")
    @Test
    void checkCalculatedAllLottosReward() {
        // given
        LottoResult result = new LottoResult(rank);

        // when, then
        assertThat(result.getLottoRewardSum()).isEqualTo(55_000);
    }
}