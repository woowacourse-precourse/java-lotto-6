package lotto.domain;

import lotto.domain.enums.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("수익률 반환 테스트")
    @Test
    void getEarningRate() {
        // given
        List<LottoRank> ranks = new ArrayList<>();
        long money = 8000;
        ranks.add(LottoRank.FIFTH);
        ranks.add(LottoRank.FOURTH);

        // when
        double earningRate = ((double) (LottoRank.FIFTH.getPrize() + LottoRank.FOURTH.getPrize()) / money) * 100;
        LottoResult lottoResult = new LottoResult(ranks);

        // then
        System.err.println(earningRate);
        assertThat(lottoResult.getEarningRate(money)).isEqualTo(earningRate);
    }
}
