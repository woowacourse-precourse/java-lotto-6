package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LottoServiceTest {

    private final LottoService lottoService = LottoService.getInstance();

    @Test
    public void testPurchaseLottos() {
        PurchasePrice money = PurchasePrice.of(10000L);
        List<PurchaseResult> purchaseResults = lottoService.purchaseLottos(money);

        assertThat(purchaseResults).hasSize(money.getPurchaseLottoAmount());
    }

    @Test
    public void testCalcRank() {
        List<Lotto> lottoTickets = new ArrayList<>();
        WinningNumbers winningNumbers = new WinningNumbers(Lotto.of(List.of(1,2,3,4,5,6)), BonusNumber.of(7));

        lottoTickets.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(Lotto.of(List.of(1, 2, 3, 4, 5, 7)));
        lottoTickets.add(Lotto.of(List.of(1, 2, 3, 4, 5, 8)));
        lottoTickets.add(Lotto.of(List.of(1, 2, 3, 4, 8, 9)));

        LottoGameResult gameResult = lottoService.calcRank(lottoTickets, winningNumbers);

        assertThat(gameResult.gameResult()).containsEntry(RankInfo.FIRST, 2);
        assertThat(gameResult.gameResult()).containsEntry(RankInfo.SECOND, 1);
        assertThat(gameResult.gameResult()).containsEntry(RankInfo.THIRD, 1);
        assertThat(gameResult.gameResult()).containsEntry(RankInfo.FOURTH, 1);
    }

    @Test
    public void testCalcYield() {
        PurchasePrice money = PurchasePrice.of(10000L);
        HashMap<RankInfo, Integer> gameResult = new HashMap<>();
        gameResult.put(RankInfo.FIFTH, 3);
        LottoGameResult lottoGameResult = new LottoGameResult(gameResult);
        YieldResult yieldResult = lottoService.calcYield(money, lottoGameResult);

        assertThat(yieldResult.yield()).isCloseTo(150, offset(0.0));
    }
}


