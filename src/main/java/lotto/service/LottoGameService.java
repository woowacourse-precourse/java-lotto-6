package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.domain.LottoWinningResult;
import lotto.domain.constant.LottoConstant;

public class LottoGameService {

    private final NumbersGenerator numbersGenerator;

    public LottoGameService(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public LottoWinningResult calculateLottoWinningResult(
            List<Lotto> lottoTickets,
            LottoPurchase lottoPurchase, LottoWinningNumber lottoWinningNumber,
            LottoBonusNumber lottoBonusNumber) {
        Map<LottoPrize, Integer> prizeCounts = new HashMap<>();
        for (Lotto lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.prize(lottoWinningNumber, lottoBonusNumber);
            prizeCounts.put(lottoPrize, prizeCounts.getOrDefault(lottoPrize, 0) + 1);
        }
        return new LottoWinningResult(lottoPurchase, prizeCounts);
    }

    public List<Lotto> purchaseLotto(LottoPurchase lottoPurchase) {
        long numTickets = lottoPurchase.countTickets();
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numTickets; ++i) {
            lottoTickets.add(new Lotto(numbersGenerator.generate(
                    LottoConstant.LOTTO_START_NUMBER,
                    LottoConstant.LOTTO_END_NUMBER,
                    LottoConstant.LOTTO_NUMBER_COUNT
            )));
        }
        return lottoTickets;
    }

}
