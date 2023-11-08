package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoService();
    }

    @Test
    public void testPurchaseLotto() {
        int purchaseAmount = 5;
        List<Lotto> purchasedLottos = lottoService.purchaseLotto(purchaseAmount);
        assertEquals(purchaseAmount, purchasedLottos.size());
    }

    @Test
    public void testCalculateResult() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        Lotto winLotto = new Lotto(winningNumbers);
        Lotto secondLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, bonusNumber));
        Lotto thirdLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto noneLotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        List<Lotto> lottoTickets = Arrays.asList(winLotto, secondLotto, thirdLotto, noneLotto);

        Map<LottoResult, Integer> results = lottoService.calculateResult(lottoTickets, winningNumbers, bonusNumber);

        assertEquals(1, results.getOrDefault(LottoResult.FIRST, 0));
        assertEquals(1, results.getOrDefault(LottoResult.SECOND, 0));
        assertEquals(1, results.getOrDefault(LottoResult.THIRD, 0));
        assertEquals(1, results.getOrDefault(LottoResult.NONE, 0));
    }

    @Test
    public void testGetEarningsRate() {
        Map<LottoResult, Integer> resultCount = Map.of(
                LottoResult.FIRST, 1,
                LottoResult.SECOND, 0,
                LottoResult.THIRD, 0,
                LottoResult.FOURTH, 0,
                LottoResult.FIFTH, 0,
                LottoResult.NONE, 4
        );

        int purchaseAmount = 5;

        double earningsRate = lottoService.getEarningsRate(resultCount, purchaseAmount);

        double expectedEarningsRate = ((double) (2_000_000_000) / (purchaseAmount * 1000)) * 100;

        assertEquals(expectedEarningsRate, earningsRate);
    }
}

