package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (!lengthValidate(numbers) || !rangeValidate(numbers) || !duplicationValidate(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = ascendingSort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean lengthValidate(List<Integer> numbers) {
        try {
            LottoValidator.containsSixNumbers(numbers.size());
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_CONTAINS_SIX_NUMBERS.getMessage());
            return false;
        }
        return true;
    }

    private boolean rangeValidate(List<Integer> numbers) {
        try {
            LottoValidator.haveValidateRange(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_RANGE.getMessage());
            return false;
        }
        return true;
    }

    private boolean duplicationValidate(List<Integer> numbers) {
        try {
            LottoValidator.haveDuplicateNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.HAVE_DUPLICATE_NUMBER.getMessage());
            return false;
        }
        return true;
    }

    private List<Integer> ascendingSort(List<Integer> list) {
        return list.stream().sorted().toList();
    }
}
