package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;

public class WinningStatistics {
    private final WinningLotto winningLotto;

    private final List<Lotto> lottoTicketsPurchased;

    private final Map<LottoPrize, Integer> prizeCounter;
    private final double rateOfReturn;

    private WinningStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased,
                              Map<LottoPrize, Integer> prizeCounter, double rateOfReturn) {
        this.winningLotto = winningLotto;
        this.lottoTicketsPurchased = lottoTicketsPurchased;
        this.prizeCounter = prizeCounter;
        this.rateOfReturn = rateOfReturn;
    }

    public WinningStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased, int usedBudget) {
        this.winningLotto = winningLotto;
        this.lottoTicketsPurchased = lottoTicketsPurchased;
        prizeCounter = new HashMap<>() {{
            Arrays.stream(LottoPrize.values())
                    .forEach(lottoPrize -> put(lottoPrize, 0));
        }};
        calculateWinningStatistics();
        rateOfReturn = calculateRateOfReturn(usedBudget);
    }

    public static WinningStatistics createDefaultWinningStatistics() {
        WinningLotto winningLotto = null;
        List<Lotto> lottoTicketsPurchased = new ArrayList<>();
        Map<LottoPrize, Integer> prizeCounter = new HashMap<>() {{
            Arrays.stream(LottoPrize.values())
                    .forEach(lottoPrize -> put(lottoPrize, 0));
        }};
        double rateOfReturn = 0;
        return new WinningStatistics(winningLotto, lottoTicketsPurchased, prizeCounter, rateOfReturn);
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

    private double calculateRateOfReturn(int usedBudget) {
        return calculateSumOfPrize() / (double) usedBudget * 100.0;
    }

    public Map<LottoPrize, Integer> getPrizeCounter() {
        return prizeCounter;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}