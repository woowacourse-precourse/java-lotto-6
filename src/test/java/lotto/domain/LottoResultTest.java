package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {
    @DisplayName("수익률을 반환한다")
    @Test
    void getProfitRate() {
        LottoResult lottoResult = new LottoResult(List.of(Rank.FIRST));
        assertThat(lottoResult.getProfitRate(new LottoMoney(1000))).isEqualTo(2000000.0);
    }

    @DisplayName("특정 등수의 개수를 반환한다")
    @Test
    void countRank() {
        LottoResult lottoResult = new LottoResult(List.of(Rank.FIRST, Rank.FIRST, Rank.FIRST));
        assertThat(lottoResult.countRank(Rank.FIRST)).isEqualTo(3);
    }
}