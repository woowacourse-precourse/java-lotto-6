package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.WinningStatistics;
import lotto.utils.LottoWinningStrategy;
import lotto.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    private final LottoWinningStrategy lottoWinningStrategy;

    public LottoService(LottoWinningStrategy lottoWinningStrategy) {
        this.lottoWinningStrategy = lottoWinningStrategy;
    }

    public List<Lotto> buyLottos(NumberGenerator numberGenerator, int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(createLotto(numberGenerator));
        }

        return lottos;
    }

    public WinningStatistics getWinningStatistics(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        List<Result> results = matchLotto(lottos, winnerNumbers, bonusNumber);

        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Result result : results) {
            rankCount.put(result.getRank(), rankCount.getOrDefault(result.getRank(), 0) + 1);
        }

        double profitRate = calculateProfitRate(results.size(), rankCount);

        WinningStatistics winningStatistics = new WinningStatistics(rankCount, profitRate);
        return winningStatistics;
    }

    private Lotto createLotto(NumberGenerator numberGenerator) {
        List<Integer> generatedNumbers = numberGenerator.generateNumbers();
        return new Lotto(generatedNumbers);
    }

    private List<Result> matchLotto(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        List<Result> results = lottos.stream()
                .map(lotto -> lotto.determineResult(lottoWinningStrategy, winnerNumbers, bonusNumber))
                .toList();

        return results;
    }

    private double calculateProfitRate(int resultSize, Map<Rank, Integer> rankCount) {
        int totalSpentAmount = 1000 * resultSize;
        int totalWinningMoney = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return (totalWinningMoney / (double) totalSpentAmount) * 100;
    }
}
