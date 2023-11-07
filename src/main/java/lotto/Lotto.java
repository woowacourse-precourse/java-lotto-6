package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final Integer NUMBER_LENGTH = 6;
    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    public static final String ERROR_NOTICE = "[ERROR]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public void validateBonusNumber(Integer bonusNumber) {
        validateSingleNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(String.format("%s 로또 번호는 %d개여야 합니다.", ERROR_NOTICE, NUMBER_LENGTH));
        }
    }

    private void validateSingleNumberRange(Integer number) {
        if ((number < NUMBER_MIN) || (NUMBER_MAX < number)) {
            throw new IllegalArgumentException(String.format("%s 로또 번호 %d가 주어진 범위를 벗어났습니다.", ERROR_NOTICE, number));
        }
    }
    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            validateSingleNumberRange(n);
        }
    }

    private void validateBonusNumberDuplicate(Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(String.format("%s 로또 번호 %d가 중복으로 포함되었습니다.", ERROR_NOTICE, number));
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer n : numbers) {
            if (!uniqueNumbers.add(n)) {
                throw new IllegalArgumentException(String.format("%s 로또 번호 %d가 중복으로 포함되었습니다.", ERROR_NOTICE, n));
            }
        }
    }
}
