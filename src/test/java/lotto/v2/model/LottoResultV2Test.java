package lotto.v2.model;

import lotto.v2.util.LottoRankV2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoResultV2Test {


    @Test
    @DisplayName("생성자는 모든 로또 순위를 0으로 초기화해야 한다.")
    void constructorShouldInitializeAllRanksWithZeroCount() {
        LottoResultV2 result = new LottoResultV2();
        for (LottoRankV2 rank : LottoRankV2.values()) {
            assertThat(result.getWinningResult()).containsEntry(rank, 0);
        }
    }

    @Test
    @DisplayName("updateMatchCount는 유효한 로또 순위에 대해 올바르게 matchCounts를 업데이트한다.")
    void updateMatchCountShouldUpdateMatchCountsCorrectlyForValidRank() {
        // given
        LottoResultV2 result = new LottoResultV2();
        LottoV2 purchasedLotto = mock(LottoV2.class);
        LottoV2 winningLotto = mock(LottoV2.class);
        int matchCount = 3; // 3개가 일치
        boolean bonusMatch = false; // 보너스 번호는 일치하지 않음
        when(purchasedLotto.matchCount(winningLotto)).thenReturn(matchCount);
        when(purchasedLotto.containsNumber(anyInt())).thenReturn(bonusMatch);

        // when
        result.updateMatchCount(purchasedLotto, winningLotto, 10);

        // then
        assertThat(result.getWinningResult()).containsEntry(LottoRankV2.valueOf(matchCount, bonusMatch), 1);
    }

    //TODO : updateMatchCount Test Code 작성

}