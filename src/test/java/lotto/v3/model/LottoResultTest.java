package lotto.v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("모든 로또 번호가 당첨 번호와 일치할 때 결과 계산")
    void testAllNumbersMatch() {
        // Given
        List<List<Integer>> purchasedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6), // 전부 일치
                Arrays.asList(7, 8, 9, 10, 11, 12) // 일치하지 않음
        );
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        // When
        LottoResult result = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = result.getMatchCounts();

        // Then
        assertThat(matchCounts.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(matchCounts.get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(matchCounts.get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(matchCounts.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(matchCounts.get(LottoRank.FIFTH)).isEqualTo(0);
    }
    
}