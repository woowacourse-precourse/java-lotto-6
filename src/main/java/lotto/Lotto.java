package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionList.LOTTOCOUNTEXCETION.content());
        }

        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException(ExceptionList.LOTTODUPLICATIONEXCEPTION.content());
        }

        if (!validateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionList.LOTTORANGEEXCEPTION.content());
        }
    }

    private Boolean validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            return true;
        }
        return false;
    }

    private Boolean validateNumber(List<Integer> numbers) {
        for (int i : numbers) {
            if (validateNumberRange(i)) {
                return false;
            }
        }
        return true;
    }
}