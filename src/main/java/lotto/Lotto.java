package lotto;

import static lotto.Util.InputValidator.checkDistinctNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    static final String ERROR = "[ERROR] ";
    static final String NOT_A_SIX_NUMBER_ERROR = "로또 숫자는 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + NOT_A_SIX_NUMBER_ERROR);
        }
        checkDistinctNumbers(numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public String getNumbers() {
        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        return result;
    }
    // TODO: 추가 기능 구현
}
