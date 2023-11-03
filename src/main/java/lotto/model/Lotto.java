package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.constant.ValidateMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        isBetween1And45(numbers);
        isDuplicate(numbers);
        sortAsc(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ValidateMessage.LOTTO_NUMBER_IS_NOT_SIZE_EQUAL_TO_SIX.throwException();
        }
    }

//    private void isBetween1And45(List<Integer> numbers) {
//        for (Integer number : numbers) {
//            if (number < 1 || number > 45) {
//                ValidateMessage.LOTTO_NUMBER_IS_BETWEEN_1_TO_45.throwException();
//            }
//        }
//    }

    private void isDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            ValidateMessage.LOTTO_NUMBER_IS_DUPLICATE.throwException();
        }
    }

    private List<Integer> sortAsc(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
