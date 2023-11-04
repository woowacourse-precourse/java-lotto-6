package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;


class LottoResultTest {
    private final LottoResult lottoResult = new LottoResult();

    @DisplayName("당첨 등수의 개수를 증가시킨다.")
    @Test
    void increaseLottoRankCount() {
        lottoResult.increaseLottoRankCount(LottoRank.THREE_MATCH);
        Map<LottoRank, Integer> result = lottoResult.getResult();

        int rankCount = result.get(LottoRank.THREE_MATCH);

        assertThat(rankCount).isEqualTo(1);
    }

    @DisplayName("당첨 결과는 읽기 전용 컬렉션이다.")
    @Test
    void resultIsReadOnly() {
        Map<LottoRank, Integer> result = lottoResult.getResult();

        assertThatThrownBy(() -> result.replace(LottoRank.OUT_RANK, 1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
