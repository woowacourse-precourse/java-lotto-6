package lotto.domian;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int bonusNumber(int bounusNumber) {
        validateBonusNumber(bounusNumber);
        return bounusNumber;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateDuplicatedBonusNumber(numbers, bonusNumber);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> validator = new HashSet<>();
        validator.addAll(numbers);
        if (validator.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> numbers, int bonusNumber) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복 되었습니다.");
            }
        }
    }
    // TODO: 추가 기능 구현
}
