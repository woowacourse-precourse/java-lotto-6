package lotto.domain.lotto;

import java.util.List;
import java.util.Optional;
import lotto.domain.lotto.validator.LottoValidator;
import lotto.domain.rank.Rank;

public record Lotto(List<Integer> numbers) {

    public Lotto(final List<Integer> numbers) {
        LottoValidator.validateNumbers(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public Optional<Rank> calculateRank(final Lotto lotto, final int bonusNumber) {
        final int matchCount = lotto.matchedCount(numbers);
        final boolean bonusBallMatched = numbers.contains(bonusNumber);
        return Rank.of(matchCount, bonusBallMatched);
    }

    public int matchedCount(final List<Integer> existingNumbers) {
        return (int) numbers
                .stream()
                .filter(existingNumbers::contains)
                .count();
    }

    public List<String> getStringNumbers() {
        return numbers
                .stream()
                .map(String::valueOf)
                .toList();
    }

    public boolean isContains(final int number) {
        return numbers.contains(number);
    }
}
