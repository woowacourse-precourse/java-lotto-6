package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Result, Integer> resultCounter;

    public LottoResult() {
        resultCounter = new HashMap<>();

        for (Result result : Result.values()) {
            resultCounter.put(result, 0);
        }
    }

    public Map<Result, Integer> calculateResult(Lotto winningLotto, List<List<Integer>> lottoPapers, int bonusNumber) {
        for (List<Integer> lottoNumbers : lottoPapers) {

            int matchCount = countMatchedNumbers(lottoNumbers, winningLotto.getLottoNumbers());
            boolean isContainsBonus = lottoNumbers.contains(bonusNumber);

            Result result = Result.resultOf(matchCount, isContainsBonus);

            resultCounter.put(result, resultCounter.get(result) + 1);
        }

        return resultCounter;
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public double getTotalRate() {
        long totalReward = calculateTotalReward();
        long totalSpent = calculateTotalSpent();

        return (double) totalReward / totalSpent * 100;
    }

    private long calculateTotalReward() {
        return this.resultCounter.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private long calculateTotalSpent() {
        return this.resultCounter.values().stream()
                .mapToLong(Long::valueOf)
                .sum() * 1000;
    }
}
