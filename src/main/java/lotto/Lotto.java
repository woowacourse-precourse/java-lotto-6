package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNoDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자의 개수가 올바르지 않습니다. 6개의 숫자를 입력해야 합니다.");
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream().distinct().count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다. 1부터 45 사이의 서로 다른 숫자 6개를 입력해주세요.");
        }
    }
}
