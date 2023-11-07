package lotto.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoWinningRankTest {

    @DisplayName("일치 번호 개수와 보너스 번호 일치 여부를 입력하면 적절한 로또 당첨 등수를 반환한다.")
    @Test
    void returnMatchedLottoWinningRank() throws Exception {
        // Given
        int matchingNumberCount = 5;
        boolean isBonusNumberMatched = true;

        // When
        LottoWinningRank lottoWinningRank = LottoWinningRank.checkWinningResult(matchingNumberCount, isBonusNumberMatched);

        // Then
        assertThat(lottoWinningRank).isEqualTo(LottoWinningRank.SECOND);
    }
}
