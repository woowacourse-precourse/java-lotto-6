package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {

    @Test
    @DisplayName("당첨 결과를 올바르게 계산한다.")
    void testCalculateWinnings() {
        // Given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        // When
        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);

        // Then
        Map<Rank, Integer> winnings = result.getWinnings();
        assertThat(winnings.get(Rank.FIRST)).isEqualTo(1);
        assertThat(winnings.get(Rank.THIRD)).isEqualTo(1);
        assertThat(winnings.get(Rank.NONE)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 상금을 올바르게 계산한다.")
    void testCalculateTotalPrize() {
        // Given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        // When
        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);

        // Then
        long totalPrize = result.getTotalPrize();
        long expectedTotalPrize = Rank.FIRST.getPrize() + Rank.THIRD.getPrize();
        assertEquals(expectedTotalPrize, totalPrize);
    }

    @Test
    @DisplayName("수익률을 올바르게 계산한다.")
    void testCalculateProfitRate() {
        // Given
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        // When
        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);

        // Then
        double profitRate = result.getProfitRate();
        long expectedTotalPrize = Rank.FIRST.getPrize() + Rank.THIRD.getPrize();
        double expectedProfitRate = ((double) expectedTotalPrize) / (lottos.size() * Lotto.PRICE);
        assertEquals(expectedProfitRate, profitRate);
    }
}
