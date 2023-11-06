package lotto.service;

import lotto.config.WinningResultConfig;
import lotto.model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    private final List<List<Integer>> userNumbers;
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final WinningResult winningResult = new WinningResult();
    private List<Result> results = new ArrayList<>();

    public LottoService(List<List<Integer> >userNumbers, List<Integer> numbers, int bonusNumber) {
        this.userNumbers = userNumbers;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    public Map<WinningResultConfig, Integer> findWinningResult() {
        countEqualNumber();

        winningResult.addResult(results);

        return winningResult.getWinningResults().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, count -> 1, (Integer::sum)));
    }

    private void countEqualNumber() {
        for (List<Integer> userNums : userNumbers) {
            long equalCount = userNums.stream()
                    .filter(number -> numbers.stream().anyMatch(Predicate.isEqual(number)))
                    .count();

            Result result = new Result(userNums, equalCount);

            if (equalCount == 5) {
                checkBonus(result);
            }
            results.add(result);
        }
    }

    private void checkBonus(Result result) {
        result.updateBonus(bonusNumber);
    }
}
