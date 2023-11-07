package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicate(numbers);
        isInRange(numbers);
        numbers = sortAscending(numbers);
        this.numbers = numbers;
    }

    public static Lotto makeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ErrorMessage.NOT_SIX_NUMBER_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void hasDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            System.out.println(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            Validator.isInRange(number);
        }
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
}
