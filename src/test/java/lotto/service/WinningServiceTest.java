package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningServiceTest {

    @Test
    @DisplayName("로또 결과 계산 테스트")
    void testCalculateResults() {
        WinningService service = new WinningService();
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        Map<LottoRank, Integer> results = service.calculateResults(lottos, winningNumbers);

        assertEquals(1, results.getOrDefault(LottoRank.FIRST, 0));
        assertEquals(1, results.getOrDefault(LottoRank.NONE, 0));
    }

    @Test
    @DisplayName("로또 등수 결정 테스트")
    void testDetermineRank() {
        WinningService service = new WinningService();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7
        );

        LottoRank rank = service.determineRank(lotto, winningNumbers);

        assertEquals(LottoRank.FIRST, rank);
    }

    @Test
    @DisplayName("총 당첨금 계산 테스트")
    void testCalculateTotalPrize() {
        WinningService service = new WinningService();
        Map<LottoRank, Integer> results = Map.of(
                LottoRank.FIRST, 1,
                LottoRank.SECOND, 2
        );

        int totalPrize = service.calculateTotalPrize(results);

        int expectedTotalPrize = LottoRank.FIRST.getPrize() + LottoRank.SECOND.getPrize() * 2;
        assertEquals(expectedTotalPrize, totalPrize);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void testCalculateYield() {
        WinningService service = new WinningService();
        int purchaseAmount = 3000;
        int totalPrize = 5000;

        double yield = service.calculateYield(purchaseAmount, totalPrize);

        double expectedYield = (double) totalPrize / purchaseAmount;
        assertEquals(expectedYield, yield);
    }
}