package lotto.v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LottoResultTest {

    @Test
    @DisplayName("주어진 구매 번호와 당첨 번호가 있을 때, LottoResult는 올바른 매치 카운트를 계산한다")
    void givenPurchasedNumbersAndWinningNumbers_whenCalculatingResults_thenItCalculatesCorrectMatchCounts() {
        // Given
        Set<Integer> purchasedNumberSet1 = new HashSet<>(Arrays.asList(8, 21, 23, 41, 42, 43));
        Set<Integer> purchasedNumberSet2 = new HashSet<>(Arrays.asList(3, 5, 11, 16, 32, 38));

        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoResult lottoResult = new LottoResult(
                Arrays.asList(purchasedNumberSet1, purchasedNumberSet2),
                winningNumbers,
                bonusNumber
        );

        // When
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // Then
        assertThat(matchCounts).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        LottoRank.FIRST, 0,
                        LottoRank.SECOND, 0,
                        LottoRank.THIRD, 0,
                        LottoRank.FOURTH, 0,
                        LottoRank.FIFTH, 1
                )
        );
    }
}

