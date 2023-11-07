package lotto.service;

import lotto.config.WinningResultConfig;
import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    private final List<List<Integer>> userNumbers;
    private final List<Integer> numbers;
    private final int bonusNumber;
    private final WinningResult winningResult = new WinningResult();
    private final List<Result> results = new ArrayList<>();

    public LottoService(List<List<Integer> >userNumbers, List<Integer> numbers, int bonusNumber) {
        this.userNumbers = userNumbers;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningResultConfig, Integer> findWinningResult() {
        for (List<Integer> userNums : userNumbers) {
            Long equalCount = countEqualNumber(userNums);

            Result result = new Result(userNums, equalCount);

            checkBonus(result, equalCount);
            results.add(result);
        }
        winningResult.addResult(results.stream().filter(result -> result.getEqualCount() >= Integer.parseInt(WinningResultConfig.THREE.getResultStatus()))
                .collect(Collectors.toList()));

        for (Map.Entry<WinningResultConfig, List<Result>> entry:  winningResult.getWinningResults().entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        return winningResult.getWinningResults().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().size()));
    }

    private Long countEqualNumber(List<Integer> userNums) {
        return userNums.stream()
                    .filter(number -> numbers.stream().anyMatch(Predicate.isEqual(number)))
                    .count();
    }

    private void checkBonus(Result result, Long equalCount) {
        if (Long.toString(equalCount).equals(WinningResultConfig.FIVE.getResultStatus())) {
            result.updateBonus(bonusNumber);
        }
    }
}
