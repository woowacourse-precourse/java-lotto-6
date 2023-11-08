package lotto.model.lotto;

import lotto.model.lotto.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    void 당첨_내역을_반환한다() {
        Assertions.assertThat(LottoRank.of(5, false)).isEqualTo(LottoRank.THIRD);
    }
}