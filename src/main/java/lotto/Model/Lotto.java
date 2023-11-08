package lotto.Model;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueness(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public Integer countWinningMatches(List<Integer> winningNum) {
        List<Integer> matchedNumbers = numbers.stream()
                .filter(lottoNumber -> winningNum.stream().anyMatch(Predicate.isEqual(lottoNumber)))
                .toList();
        return matchedNumbers.size();
    }

    public Integer countBonusWinningMatches(Integer bonusWinningNum) {
        return Boolean.compare(numbers.contains(bonusWinningNum), true) + 1;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
