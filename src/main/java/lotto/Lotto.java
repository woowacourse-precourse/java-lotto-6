package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        boolean isInvalidRange = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);
        if(isInvalidRange)
            throw new IllegalArgumentException();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        boolean isDuplicated = numbers.size() != uniqueNumbers.size();
        if(isDuplicated)
            throw new IllegalArgumentException();
    }

    public String toString() {
        return numbers.toString();
    }

    public LottoResult judgeResult(int matched, boolean isBonusMatched) {
        if(matched == 6)
            return LottoResult.SIX;
        if(matched == 5 && isBonusMatched)
            return LottoResult.FIVE_BONUS;
        if(matched == 5)
            return LottoResult.FIVE;
        if(matched == 4)
            return LottoResult.FOUR;
        if(matched == 3)
            return LottoResult.THREE;
        throw new IllegalArgumentException();
    }

    public LottoResult getLottoResult(Lotto winning, int bonus) {
        int matched = 0;
        for(Integer number : winning.numbers) {
            if(this.numbers.contains(number))
                matched++;
        }
        boolean isBonusMatched = this.numbers.contains(bonus);
        return judgeResult(matched, isBonusMatched);
    }
}
