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
    private static final int LOTTO_PRICE = 1000;
    private static final int DEFAULT_WINNING_COUNT = 0;

    private final LottoWinningStrategy lottoWinningStrategy;
    private final NumberGenerator numberGenerator;

    public LottoService(LottoWinningStrategy lottoWinningStrategy, NumberGenerator numberGenerator) {
        this.lottoWinningStrategy = lottoWinningStrategy;
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> buyLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>(lottoQuantity);
        for (int currentLottoQuantity = 0; currentLottoQuantity < lottoQuantity; currentLottoQuantity++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    public WinningStatistics getWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusBall) {
        List<Result> results = matchLottos(lottos, winningNumbers, bonusBall);

        Map<Rank, Integer> winningCount = new HashMap<>();
        for (Result result : results) {
            winningCount.put(result.getRank(), winningCount.getOrDefault(result.getRank(), DEFAULT_WINNING_COUNT) + 1);
        }

        double profitRate = calculateProfitRate(results.size(), winningCount);

        WinningStatistics winningStatistics = new WinningStatistics(winningCount, profitRate);
        return winningStatistics;
    }

    private Lotto createLotto() {
        List<Integer> generatedNumbers = numberGenerator.generateNumbers();
        return new Lotto(generatedNumbers);
    }

    private List<Result> matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusBall) {
        List<Result> results = lottos.stream()
                .map(lotto -> lotto.determineResult(lottoWinningStrategy, winningNumbers, bonusBall))
                .toList();

        return results;
    }

    private double calculateProfitRate(int resultSize, Map<Rank, Integer> winningCount) {
        int totalPurchaseAmount = LOTTO_PRICE * resultSize;
        int totalWinningMoney = winningCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        return (totalWinningMoney / (double) totalPurchaseAmount) * 100;
    }
}
