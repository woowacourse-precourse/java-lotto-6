package lotto;

import static lotto.ExceptionMessage.ERROR_LOTTO_COUNT;
import static lotto.ExceptionMessage.ERROR_LOTTO_DUPICATED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); // 복제된 리스트 생성
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT.getMessage());
        }
        validateDuplicateNumber(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPICATED.getMessage());
        }
    }

    public List<Integer> getNumbers() {

        return numbers;
    }

    // TODO: 추가 기능 구현

    public LottoPrize checkMatchingNumbers(Lotto winningLotto, int bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int matchingCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchingCount++;
            }
        }

        boolean hasBonusNumber = winningNumbers.contains(bonusNumber);

        if (matchingCount == 6) {
            return LottoPrize.MATCH_6;
        } else if (matchingCount == 5 && hasBonusNumber) {
            return LottoPrize.MATCH_5_BONUS;
        } else if (matchingCount == 5) {
            return LottoPrize.MATCH_5;
        } else if (matchingCount == 4) {
            return LottoPrize.MATCH_4;
        } else if (matchingCount == 3) {
            return LottoPrize.MATCH_3;
        } else {
            return null; // 일치하지 않는 경우
        }
    }
}
