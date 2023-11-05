package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;

public class Player {
    private int budget;
    private int usedBudget;
    private List<Lotto> lottoTickets;
    private WinningStatistics winningStatistics;

    public Player() {
        budget = 0;
        usedBudget = 0;
        lottoTickets = new ArrayList<>();
        winningStatistics = WinningStatistics.createDefaultWinningStatistics();
    }

    public void buyLottoTickets(LottoShop lottoShop) {
        List<Lotto> purchased = lottoShop.createLottoTickets(budget);
        usedBudget += purchased.size() * lottoShop.getLottoTicketPrice();
        lottoTickets.addAll(purchased);
    }

    public void calculateWinningLottoWithMine(WinningLotto winningLotto) {
        winningStatistics = calculateWinningStatistics(winningLotto);
    }

    private WinningStatistics calculateWinningStatistics(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> prizeCounter = calculatePrizeCounter(winningLotto);
        double rateOfReturn = calculateRateOfReturn(prizeCounter);
        return new WinningStatistics(winningLotto, lottoTickets, prizeCounter, rateOfReturn);
    }

    private Map<LottoPrize, Integer> calculatePrizeCounter(WinningLotto winningLotto) {
        Map<LottoPrize, Integer> prizeCounter = new HashMap<>() {{
            Arrays.stream(LottoPrize.values())
                    .forEach(lottoPrize -> put(lottoPrize, 0));
        }};

        for (Lotto lotto : lottoTickets) {
            LottoPrize lottoPrize = winningLotto.match(lotto);
            prizeCounter.put(lottoPrize, prizeCounter.get(lottoPrize) + 1);
        }
        return prizeCounter;
    }

    private double calculateRateOfReturn(Map<LottoPrize, Integer> prizeCounter) {
        return calculateSumOfPrize(prizeCounter) / (double) usedBudget * 100.0;
    }

    public Long calculateSumOfPrize(Map<LottoPrize, Integer> prizeCounter) {
        long sum = 0L;
        for (LottoPrize lottoPrize : prizeCounter.keySet()) {
            Long count = Long.valueOf(prizeCounter.get(lottoPrize));
            Long prize = lottoPrize.getPrize();
            sum += prize * count;
        }
        return sum;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}