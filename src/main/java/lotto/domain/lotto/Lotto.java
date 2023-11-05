package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplication(numbers);
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요");
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
            }
        }
    }
    private static void validateNumbersDuplication(List<Integer> numbers) {
        long numberCount = numbers.stream()
                .distinct()
                .count();
        if(numberCount != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
