package lotto.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static lotto.model.LottoAttribute.LOTTO_TICKET_SIZE;
import static lotto.exception.ErrorType.INVALID_TICKET_SIZE;
import static lotto.exception.ErrorType.NUMBERS_DUPLICATED;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = mapNumbers(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(INVALID_TICKET_SIZE.getMessage());
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATED.getMessage());
        }
    }

    private List<LottoNumber> mapNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::of)
                .toList();
    }

    public boolean contains(final LottoNumber number) {
        return numbers.contains(number);
    }

    public MatchCount findMatchCount(final Lotto other) {
        final int numberOfMatches = getNumberOfMatches(other);
        return MatchCount.of(numberOfMatches);
    }

    private int getNumberOfMatches(final Lotto other) {
        return numbers.stream()
                .filter(other::contains)
                .collect(collectingAndThen(counting(), Long::intValue));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
