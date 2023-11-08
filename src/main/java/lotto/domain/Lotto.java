package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String prefix = "[ERROR]";
    private static final String NUMBER_SIZE_ERROR = "입력이 필요한 숫자는 6개 입니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "중복된 숫자가 입력 되었습니다.";
    private static final String NUMBER_RANGE_ERROR = "입력이 필요한 숫자의 범위는 1 ~ 45 입니다.";
    private final int NUMBERS_SIZE = 6;
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(prefix + NUMBER_SIZE_ERROR);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> validateNumbers = new HashSet<>();
        validateNumbers.addAll(numbers);
        if (validateNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(prefix + DUPLICATED_NUMBER_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 입력이 필요한 숫자의 범위는 1 ~ 45 입니다.");
            }
        }
    }

    public int bonusNumber(int number) {
        validateBonusNumber(number);
        return number;
    }

    private void validateBonusNumber(int number) {
        validateDuplicatedBonusNumber(numbers, number);
        validateBonusRange(number);
    }

    private void validateDuplicatedBonusNumber(List<Integer> numbers, int number) {
        for (int i: numbers) {
            if (i == number) {
                throw new IllegalArgumentException(prefix + DUPLICATED_NUMBER_ERROR);
            }
        }
    }

    private void validateBonusRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(prefix + NUMBER_RANGE_ERROR);
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
