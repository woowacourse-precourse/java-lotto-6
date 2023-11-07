package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateDuplicateNumber(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호에 중복된 번호가 있습니다. 다른 번호를 입력하세요.");
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
