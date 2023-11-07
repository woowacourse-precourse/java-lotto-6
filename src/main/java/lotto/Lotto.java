package lotto;

import static lotto.enums.LottoConstants.LOTTO_PER_NUMBERS;
import static lotto.enums.LottoErrorMessageConstants.LOTTO_HAS_DUPLICATE_NUMBER;
import static lotto.enums.LottoErrorMessageConstants.LOTTO_INVALID_SIZE;
import static lotto.enums.LottoPrizeConstants.BONUS_PRIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.LottoPrizeConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_INVALID_SIZE.getMessage());
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        return notDuplicateNumbers.size() != LOTTO_PER_NUMBERS.getConstant();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoPrizeConstants checkPrize(List<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchedCount++;
            }
        }
        /* 보너스 번호를 check 해야할 경우 */
        if ((matchedCount == BONUS_PRIZE.getMatchingNumber() - 1) && numbers.contains(bonusNumber)) {
            return BONUS_PRIZE;
        }
        return LottoPrizeConstants.getPrizeByMatchingNumber(matchedCount);
    }
}
