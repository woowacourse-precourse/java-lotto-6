package lotto.core;

import java.util.List;
import static lotto.utils.Validator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers); // 길이 검사
        hasDuplicateInNumbers(numbers); // 중복 검사
        validateIsNumbersInRange(numbers); // 1~45 사이 검사
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
