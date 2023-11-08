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

    @Test
    @DisplayName("6개 번호가 모두 일치할 경우 FIRST 순위가 올바르게 계산되어야 한다.")
    void shouldCalculateFirstRankCorrectly() {
        // given
        List<Set<Integer>> purchasedNumbers = List.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;  // Not relevant for FIRST rank

        // when
        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts.get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치할 경우 SECOND 순위가 올바르게 계산되어야 한다.")
    void shouldCalculateSecondRankCorrectly() {
        // given
        List<Set<Integer>> purchasedNumbers = List.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;  // Relevant for SECOND rank

        // when
        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts.get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호가 일치할 경우 THIRD 순위가 올바르게 계산되어야 한다.")
    void shouldCalculateThirdRankCorrectly() {
        // given
        List<Set<Integer>> purchasedNumbers = List.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 8)));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;  // Not relevant for THIRD rank

        // when
        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts.get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 번호가 일치할 경우 FOURTH 순위가 올바르게 계산되어야 한다.")
    void shouldCalculateFourthRankCorrectly() {
        // given
        List<Set<Integer>> purchasedNumbers = List.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 9;  // Not relevant for FOURTH rank

        // when
        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts.get(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("3개 번호가 일치할 경우 FIFTH 순위가 올바르게 계산되어야 한다.")
    void shouldCalculateFifthRankCorrectly() {
        // given
        List<Set<Integer>> purchasedNumbers = List.of(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;  // Not relevant for FIFTH rank

        // when
        LottoResult lottoResult = new LottoResult(purchasedNumbers, winningNumbers, bonusNumber);
        Map<LottoRank, Integer> matchCounts = lottoResult.getMatchCounts();

        // then
        assertThat(matchCounts.get(LottoRank.FIFTH)).isEqualTo(1);
    }
}