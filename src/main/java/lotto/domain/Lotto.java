package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ExceptionMessages;
import lotto.enums.LottoPrize;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private Boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        return compareNumbers.size() != numbers.size();
    }

    public LottoPrize getLottoRank(Lotto winningNumber, Integer bonusNumber) {
        Integer matchingCount = compareLotto(winningNumber.getNumbers());
        Boolean hasBonusNumber = this.numbers.contains(bonusNumber);
        if (matchingCount == 6) {
            return LottoPrize.SIX_MATCH;
        } else if (matchingCount == 5 && hasBonusNumber) {
            return LottoPrize.FIVE_MATCH_BONUS;
        } else if (matchingCount == 5) {
            return LottoPrize.THREE_MATCH;
        } else if (matchingCount == 4) {
            return LottoPrize.FOUR_MATCH;
        } else if (matchingCount == 3) {
            return LottoPrize.THREE_MATCH;
        }
        return LottoPrize.NOT_THING_MATCH;
    }

    private Integer compareLotto(List<Integer> winningLotto) {
        Integer matchingCount = 0;
        for (Integer userLottoNumber : this.numbers) {
            if (winningLotto.contains(userLottoNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
