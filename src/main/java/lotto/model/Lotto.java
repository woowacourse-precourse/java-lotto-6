package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.config.AppConfig;
import lotto.model.win.WinResult;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate(distinct(numbers));
        validate(validRange(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != AppConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> distinct(List<Integer> numbers) {
        return numbers.stream().distinct().toList();
    }

    private List<Integer> validRange(List<Integer> numbers) {
        return numbers.stream().filter(integer -> integer <= AppConfig.LOTTO_NUMBER_MAX_RANGE)
                .filter(integer -> integer >= AppConfig.LOTTO_NUMBER_MIN_RANGE)
                .toList();
    }

    public WinResult checkResult(List<Integer> target, int bonus) {
        int count = checkWithTarget(target);
        boolean canBeSecond = checkBonusIfUsable(count, bonus);

        return Arrays.stream(WinResult.values())
                .filter(winResult -> winResult.matchedCount == count)
                .filter(winResult -> winResult.bonus == canBeSecond)
                .findAny()
                .orElse(WinResult.FAIL);
    }

    private int checkWithTarget(List<Integer> target) {
        return (int) numbers.stream()
                .filter(num -> target.contains(num))
                .count();
    }

    private boolean checkBonusIfUsable(int count, int bonus) {
        if(count == WinResult.THIRD.matchedCount) {
            return numbers.contains(bonus);
        }
        return false;
    }
}
