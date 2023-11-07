package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Constant.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        isDuplicate(numbers);
    }

    //6개인지 확인
    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_NOT_COUNT_MESSAGE);
        }
    }

    //중복된 숫자 확인
    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Constant.LOTTO_LENGTH) {
            throw new IllegalArgumentException(
                    Constant.ERROR_PREFIX + Constant.USER_NUMBER_PREFIX + Constant.ERROR_DUPLICATE_MESSAGE);
        }
    }
}
