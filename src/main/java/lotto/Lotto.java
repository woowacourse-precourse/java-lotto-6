package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Long> matchUserNumberWithWinningNumbers(Map<Long, List<Integer>> lotteryNumbers) {
        Map<String, Long> matchResult = new HashMap<>();
        return matchResult;
    }

    // TODO: 추가 기능 구현
}
