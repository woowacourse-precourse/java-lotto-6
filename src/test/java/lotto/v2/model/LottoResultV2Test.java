package lotto.v2.model;

import lotto.v2.util.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultV2Test {

    @Test
    @DisplayName("생성자는 모든 로또 순위를 0으로 초기화해야 한다.")
    void constructorShouldInitializeAllRanksWithZeroCount() {
        LottoResultV2 result = new LottoResultV2();
        for (LottoRank rank : LottoRank.values()) {
            assertThat(result.getWinningResult()).containsEntry(rank, 0);
        }
    }

}