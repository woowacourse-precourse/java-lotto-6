package lotto.v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("구매한 로또 번호가 당첨 번호와 모두 일치하지 않는 경우, 결과가 올바르게 계산되어야 한다.")
    void shouldCalculateResultsCorrectlyWhenNoNumbersMatch() {
        // given
        List<Set<Integer>> purchasedNumbers = Arrays.asList(
                new HashSet<>(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new HashSet<>(Arrays.asList(3, 5, 11, 16, 32, 38))
        );
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);

        // when
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts).hasSize(5)
                .containsEntry(LottoRank.FIRST, 0)
                .containsEntry(LottoRank.SECOND, 0)
                .containsEntry(LottoRank.THIRD, 0)
                .containsEntry(LottoRank.FOURTH, 0)
                .containsEntry(LottoRank.FIFTH, 0);
    }
}