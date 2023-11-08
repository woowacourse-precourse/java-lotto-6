package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.dto.BuyLottoInfo;
import lotto.domain.PurchaseLottos;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoWinResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private WinningLotto winningLotto;
    private PurchaseLottos purchaseTickets;

    public BuyLottoInfo createLottoTickets(int amount) {
        purchaseTickets = new PurchaseLottos(amount);
        return purchaseTickets.getBuyLottoInfo();
    }

    public void createWinningLotto(List<Integer> numbers, BonusNumber bonusNumber){
        winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    public LottoWinResult checkWinningLotto() {
        int purchaseAmount = purchaseTickets.getPurchaseAmount();
        Map<WinningRank, Integer> winningRankCount = winningLotto.checkPrize(purchaseTickets);

        LottoWinResult lottoWinResult = new LottoWinResult(purchaseAmount, winningRankCount);
        return lottoWinResult;
    }

}
