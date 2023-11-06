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

    private Map<String, Integer> matchUserNumberWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> matchingResult = new HashMap<>();
        matchingResult.put("matchingWinningNumbers", 0);
        matchingResult.put("matchingBonusNumbers", 0);
        for (Integer winningNumber : winningNumbers) {
            if (this.numbers.contains(winningNumber)) {
                Integer i = matchingResult.get("matchingWinningNumbers");
                matchingResult.put("matchingWinningNumbers", i + 1);
            }
        }
        if (this.numbers.contains(bonusNumber)) {
            matchingResult.put("matchingBonusNumbers", 1);
        }
        return matchingResult;
    }

    public int getWinningRank(List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> matchingResult = matchUserNumberWithWinningNumbers(winningNumbers, bonusNumber);
        if (matchingResult.get("matchingWinningNumbers")==6){
            return 1;
        }
        if (matchingResult.get("matchingWinningNumbers")==5){
            if (matchingResult.get("matchingBonusNumbers")==1){
                return 2;
            }
            return 3;
        }
       return 8-matchingResult.get("matchingWinningNumbers");
    }
}
