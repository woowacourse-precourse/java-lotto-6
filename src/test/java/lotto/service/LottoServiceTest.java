package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;
    private Lotties purchasedLotties;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        purchasedLotties = lottoService.buyLotties(7000); // Example: Buying 7 lottos
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("가격에 맞는 개수로 로또를 구매한다")
    @Test
    void testBuyLotties() {
        assertNotNull(purchasedLotties);
        assertEquals(7, purchasedLotties.size());
    }

    @DisplayName("로또 결과에 해당하는 수익을 반환한다")
    @Test
    void testGetProfitability() {
        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.MATCH_3, 3);
        rankCounts.put(Rank.MATCH_4, 2);
        int money = 7000;

        double profitability = lottoService.getProfitability(rankCounts, money);
        double profit = 3 * Rank.MATCH_3.getPrize() + 2 * Rank.MATCH_4.getPrize();

        assertEquals(profit / (double) money * 100, profitability, 0.01);
    }

    @DisplayName("당첨로또와 비교해서 유의미한 순위를 EnumMap에 저장한다.")
    @Test
    void testGetWinningStatistics() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        Lotties lotties = new Lotties(lottoList);
        EnumMap<Rank, Integer> rankCounts = lottoService.getWinningStatistics(lotties, winningLotto, 7);
        assertNull(rankCounts.get(Rank.MATCH_3));
        assertNull(rankCounts.get(Rank.MATCH_4));
        assertNull(rankCounts.get(Rank.MATCH_5));
        assertNull(rankCounts.get(Rank.MATCH_5_BONUS));
        assertEquals(1, rankCounts.get(Rank.MATCH_6));
    }
}