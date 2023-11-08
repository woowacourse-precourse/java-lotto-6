package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumValidator implements BasicValidator<List<Integer>> {
    @Override
    public void validate(List<Integer> numbers) {
        isInputEmpty(numbers);
        hasSixNums(numbers);
        isRangeValid(numbers);
        hasDuplicateNums(numbers);
    }

    public void isInputEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    public void hasSixNums(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    public void isRangeValid(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void hasDuplicateNums(List<Integer> numbers) {
        Set<Integer> uniqueNums = new HashSet<>(numbers);

        if (uniqueNums.size() < numbers.size()) {
            throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 있으면 안됩니다.");
        }
    }
}