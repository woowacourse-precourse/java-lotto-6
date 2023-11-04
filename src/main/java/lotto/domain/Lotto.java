package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utility.LottoErrorMessage;

// 입력하는 당첨 번호 6개
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 입력값이 6개인지
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.WRONG_SIZE_ERROR.getMessage());
        }
    }

    // 중복 요소가 있는지
    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_ERROR.getMessage());
        }
    }

    // 각 요소가 1부터 45까지인
    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoErrorMessage.OUT_RANGE_ERROR.getMessage());
            }
        }
    }
}
