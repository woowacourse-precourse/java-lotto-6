package lotto;

import java.util.List;
import java.util.function.Predicate;

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

    public Integer countWinningMatches(List<Integer> winningNum){
        List<Integer> matchedNumbers = numbers.stream()
                .filter(lottoNumber -> winningNum.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .toList();

        return matchedNumbers.size();
    }

    public Integer countBonusWinningMatches(Integer bonusWinningNum){
        boolean isContained = numbers.contains(bonusWinningNum)
        return Boolean.compare(isContained, true) + 1;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
