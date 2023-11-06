package lotto.model;

import lotto.model.value.Matching;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

    private Map<Matching, Integer> result;
    private double rate;

    public Result() {
        result = Arrays.stream(Matching.values())
                .collect(Collectors.toMap(matching -> matching, matching -> 0));
    }

    public Map<Matching, Integer> getResult() {
        return result;
    }

    public double getRate() {
        return rate;
    }

    public void updateResult(int count, Lotto lotto, WinningNumber winningNumber) {
        if (isCountFive(count) && DoBonusPointsMatch(lotto, winningNumber)) {
            increaseCount(Matching.of("5-1"));
            return;
        }

        increaseCount(Matching.of(String.valueOf(count)));
    }

    private void increaseCount(Matching matching) {
        result.put(matching, result.get(matching) + 1);
    }

    private boolean isCountFive(int count) {
        return count == 5;
    }

    private boolean DoBonusPointsMatch(Lotto lotto, WinningNumber winningNumber) {
        return lotto.getNumbers().stream().anyMatch(number -> number == winningNumber.getBonusNumber());
    }
}
