package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.constants.IntegerConstants;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidLengthException;
import lotto.exceptions.InvalidNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != IntegerConstants.LOTTO_NUMBERS_COUNT) {
            throw new InvalidLengthException();
        }

        long validNumbersCount = numbers.stream()
                .filter(n -> IntegerConstants.LOTTO_RANGE_START <= n && n <= IntegerConstants.LOTTO_RANGE_END).count();
        if (validNumbersCount != IntegerConstants.LOTTO_NUMBERS_COUNT) {
            throw new InvalidNumberException();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != IntegerConstants.LOTTO_NUMBERS_COUNT) {
            throw new DuplicateException();
        }
    }

    public LottoMatchType match(List<Integer> winnings, Integer bonus) {
        long matchCount = winnings.stream().filter(numbers::contains).count();
        if (matchCount == 5 && numbers.contains(bonus)) {
            return LottoMatchType.MATCH_FIVE_BONUS;
        }
        Map<Long, LottoMatchType> mapping = Map.ofEntries(
                Map.entry(3L, LottoMatchType.MATCH_THREE),
                Map.entry(4L, LottoMatchType.MATCH_FOUR),
                Map.entry(5L, LottoMatchType.MATCH_FIVE),
                Map.entry(6L, LottoMatchType.MATCH_SIX)
        );
        if (!mapping.containsKey(matchCount)) {
            return LottoMatchType.MATCH_NONE;
        }
        return mapping.get(matchCount);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
