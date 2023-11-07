package lotto.domain;

import java.util.HashSet;
import java.util.List;
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
        int matchCount = 0;
        for (Integer w : winnings) {
            if (numbers.contains(w)) {
                matchCount += 1;
            }
        }
        if (matchCount < 3) {
            return LottoMatchType.MATCH_NONE;
        }
        if (matchCount == 3) {
            return LottoMatchType.MATCH_THREE;
        }
        if (matchCount == 4) {
            return LottoMatchType.MATCH_FOUR;
        }
        if (matchCount == 5 && !numbers.contains(bonus)) {
            return LottoMatchType.MATCH_FIVE;
        }
        if (matchCount == 5 && numbers.contains(bonus)) {
            return LottoMatchType.MATCH_FIVE_BONUS;
        }
        return LottoMatchType.MATCH_SIX;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
