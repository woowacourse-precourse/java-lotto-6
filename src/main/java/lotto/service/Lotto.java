package lotto.service;

import static lotto.constant.ErrorMessage.WINNUMBER_LENGTH;
import static lotto.constant.ErrorMessage.WINNUMBER_NO_DUPLICATE_LENGTH;
import static lotto.constant.NumberConstant.NUMBERS_LENGTH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateLotto = new HashSet<>(numbers);
        List<Integer> numberNonDuplicate = new ArrayList<>(nonDuplicateLotto);
        if (numberNonDuplicate.size() != NUMBERS_LENGTH.getNumber()) {
            throw new IllegalArgumentException(WINNUMBER_NO_DUPLICATE_LENGTH.getMessage());
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH.getNumber()) {
            throw new IllegalArgumentException(WINNUMBER_LENGTH.getMessage());
        }
    }

}
