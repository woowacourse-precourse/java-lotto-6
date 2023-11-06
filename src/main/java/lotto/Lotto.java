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
        for (Integer number : numbers) {
            if (numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Map<String, Integer> matchUserNumberWithWinningNumbers(List<Integer> winningNumbers, int bonusNumbers) {
        Map<String, Integer> matchingResult = new HashMap<>();
        matchingResult.put("matchingWinningNumbers", 0);
        matchingResult.put("matchingBonusNumbers", 0);
        for (Integer winningNumber : winningNumbers) {
            if (this.numbers.contains(winningNumber)) {
                Integer i = matchingResult.get("matchingWinningNumbers");
                matchingResult.put("matchingWinningNumbers", i + 1);
            }
        }
        if (this.numbers.contains(bonusNumbers)) {
            matchingResult.put("matchingBonusNumbers", 1);
        }
        return matchingResult;
    }

}
