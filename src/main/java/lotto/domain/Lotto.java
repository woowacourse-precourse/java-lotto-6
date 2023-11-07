package lotto.domain;

import static lotto.domain.LottoPrize.*;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        System.out.println(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    LottoPrize confirmWinning(Set<Integer> winningNumbers, int bonusNumber) {
        int hits = 0;
        boolean bonusHit = false;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                hits += 1;
            } else if (number == bonusNumber) {
                bonusHit = true;
            }
        }

        if (hits == THREE_MATCH.getMatches()) {
            return THREE_MATCH;
        } else if (hits == FOUR_MATCH.getMatches()) {
            return FOUR_MATCH;
        } else if (hits == FIVE_MATCH.getMatches()) {
            if (bonusHit) {
                return FIVE_MATCH_WITH_BONUS;
            }
            return FIVE_MATCH;
        } else if (hits == SIX_MATCH.getMatches()) {
            return SIX_MATCH;
        }
        return null;
    }
}
