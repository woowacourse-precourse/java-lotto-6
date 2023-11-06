package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.domain.LottoWinningResult;

public class LottoGameService {

    private final LottoGenerator lottoGenerator;

    public LottoGameService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoWinningResult calculateLottoWinningResult(
            List<Lotto> lottoTickets,
            LottoPurchase lottoPurchase, LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber) {
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        for (Lotto lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.prize(lottoWinningNumber, lottoBonusNumber);
            prizeCountMap.put(lottoPrize, prizeCountMap.getOrDefault(lottoPrize, 0) + 1);
        }
        return new LottoWinningResult(lottoPurchase, prizeCountMap);
    }

    public List<Lotto> purchaseLotto(LottoPurchase lottoPurchase) {
        return lottoPurchase.purchase(lottoGenerator);
    }

}
