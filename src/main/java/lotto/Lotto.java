package lotto;

import java.util.List;

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

    // TODO: 추가 기능 구현

    public LottoMatchResult match(List<Integer> winnings, int bonus) {
        int matchCount = 0;
        for (Integer w : winnings) {
            if (numbers.contains(w)) {
                matchCount += 1;
            }
        }
        if (matchCount < 3) {
            return LottoMatchResult.MATCH_NONE;
        }
        if (matchCount == 3) {
            return LottoMatchResult.MATCH_THREE;
        }
        if (matchCount == 4) {
            return LottoMatchResult.MATCH_FOUR;
        }
        if (matchCount == 5 && !numbers.contains(bonus)) {
            return LottoMatchResult.MATCH_FIVE;
        }
        if (matchCount == 5 && numbers.contains(bonus)) {
            return LottoMatchResult.MATCH_FIVE_BONUS;
        }
        return LottoMatchResult.MATCH_SIX;
    }

    public boolean matchBonus(Integer bonus) {
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
