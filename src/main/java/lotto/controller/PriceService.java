package lotto.controller;

import lotto.model.Percent;
import lotto.model.PriceMoney;
import lotto.model.Ranking;
import lotto.view.ConsoleView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceService {
    private List<Ranking> lottoResult;
    private LottoService lottoService;
    private Map<Ranking, Integer> rankingCounts = new HashMap<>();
    private PriceMoney priceMoney = new PriceMoney(0);
    private Percent incomingRate;

    public PriceService(LottoService lottoService) {
        this.lottoService = lottoService;
        this.lottoResult = lottoService.calculateRankingResults();
    }

    private void countRanking() {
        for (Ranking ranking: lottoResult) {
            if (!rankingCounts.containsKey(ranking)) {
                rankingCounts.put(ranking, 0);
                continue;
            }
            int currentCount = rankingCounts.get(ranking);
            rankingCounts.put(ranking, currentCount + 1);
        }
    }

    private void printRankingStatus() {
        ConsoleView.printRankingResult(rankingCounts);
    }

    private void calculatePrice() {
        rankingCounts.forEach((ranking, count) -> {
            try {
                PriceMoney currentRankingPrice = ranking.calculateCurrentPrice(count);
                priceMoney.add(currentRankingPrice);
            } catch (IllegalArgumentException illegalArgumentException) {
                ConsoleView.printErrorMessage(illegalArgumentException.getMessage());
            }
        });
    }

    private void calculateIncomeRate() {
        incomingRate = lottoService.calculateIncomeRate(priceMoney);
    }

    private void printIncomeRate() {
        ConsoleView.printIncomeRate(incomingRate);
    }

    public void start() {
        countRanking();
        printRankingStatus();
        calculatePrice();
        calculateIncomeRate();
        printIncomeRate();
    }
}
