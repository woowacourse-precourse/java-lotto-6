package lotto;

import lotto.view.ErrorMessage;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateIsDuplicationErrorCheck(numbers);
        validateMaxAndMinNum(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.notValue());
        }
    }

//     TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static void validateIsDuplicationErrorCheck(List<Integer> numbers) {
        Set<Integer> setList = new HashSet<>();
        for (Integer number: numbers) {
            if (!setList.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.isDuplication());
            }
        }
    }
    public static void validateMaxAndMinNum(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.isMaxAndMinValue());
            }
        }
    }
}
