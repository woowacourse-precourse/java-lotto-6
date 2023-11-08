package lotto;

import java.util.HashSet;
import java.util.List;
import io.Output;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Output.errorHitNumberCountIsNotValidMessage);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (numberSet.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
            }
            numberSet.add(number);
        }

    }

}


