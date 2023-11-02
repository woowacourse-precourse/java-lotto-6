package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSizeOfNumbers(numbers);
        validateDuplicateNumber(numbers);
        checkValidNumbersInLotto(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateSizeOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 6개 번호가 입력되지 않았습니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long uniqueLottoNumSize = numbers.stream()
                .distinct()
                .count();

        if (uniqueLottoNumSize != 6) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 번호가 존재합니다.");
        }
    }

    private void checkValidNumbersInLotto(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
