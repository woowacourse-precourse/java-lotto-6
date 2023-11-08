package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validDuplicate(List<Integer> numbers) {
        // 중복값 없는지 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public String printLottoNumbers() {
        return numbers.toString();
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchingCount = 0;
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    public int countMatchingBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}
