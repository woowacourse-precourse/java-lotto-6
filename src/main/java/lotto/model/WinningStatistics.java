package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoConstants;
import lotto.constant.LottoPrize;

public class WinningStatistics {
    private final WinningLotto winningLotto;

    private final List<Lotto> lottoTicketsPurchased;

    private final Map<LottoPrize, Integer> prizeCounter;
    private final double rateOfReturn;

    public WinningStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased) {
        this.winningLotto = winningLotto;
        this.lottoTicketsPurchased = lottoTicketsPurchased;
        prizeCounter = calculateWinningStatistics();
        rateOfReturn = calculateSumOfPrize() / (double) (lottoTicketsPurchased.size()
                * LottoConstants.THE_PRICE_OF_ONE_LOTTO_TICKET) * 100.0;
    }

    public Map<LottoPrize, Integer> getPrizeCounter() {
        return prizeCounter;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private Map<LottoPrize, Integer> calculateWinningStatistics() {
        Map<LottoPrize, Integer> prizeCounter = new HashMap<>();
        for (Lotto lotto : lottoTicketsPurchased) {
            LottoPrize lottoPrize = winningLotto.compare(lotto);
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            addPrize(prizeCounter, lottoPrize);
        }
        return prizeCounter;
    }

    private void addPrize(Map<LottoPrize, Integer> prizeCount, LottoPrize lottoPrize) {
        if (prizeCount.containsKey(lottoPrize)) {
            prizeCount.put(lottoPrize, prizeCount.get(lottoPrize) + 1);
            return;
        }
        prizeCount.put(lottoPrize, 1);
    }

    private Long calculateSumOfPrize() {
        long sum = 0L;
        for (LottoPrize lottoPrize : prizeCounter.keySet()) {
            Long count = Long.valueOf(prizeCounter.get(lottoPrize));
            Long prize = lottoPrize.getPrize();
            sum += prize * count;
        }
        return sum;
    }
}
