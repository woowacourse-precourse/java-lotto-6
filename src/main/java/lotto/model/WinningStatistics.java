package lotto.model;

import java.util.Arrays;
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
        prizeCounter = new HashMap<>() {{
            Arrays.stream(LottoPrize.values())
                    .forEach(lottoPrize -> put(lottoPrize, 0));
        }};
        calculateWinningStatistics();
        rateOfReturn = calculateRateOfReturn(lottoTicketsPurchased);
    }

    public Map<LottoPrize, Integer> getPrizeCounter() {
        return prizeCounter;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private void calculateWinningStatistics() {
        for (Lotto lotto : lottoTicketsPurchased) {
            LottoPrize lottoPrize = winningLotto.compare(lotto);
            addPrize(lottoPrize);
        }
    }

    private void addPrize(LottoPrize lottoPrize) {
        prizeCounter.put(lottoPrize, prizeCounter.get(lottoPrize) + 1);
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

    private double calculateRateOfReturn(List<Lotto> lottoTicketsPurchased) {
        return calculateSumOfPrize() / (double) (lottoTicketsPurchased.size()
                * LottoConstants.THE_PRICE_OF_ONE_LOTTO_TICKET) * 100.0;
    }
}
