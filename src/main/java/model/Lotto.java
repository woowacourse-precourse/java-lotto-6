package model;

import message.Regex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;
    private static final Integer MINLOTTO = 1;
    private static final Integer MAXLOTTO = 45;
    private static final Integer LOTTOSIZE = 6;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTOSIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean invalidRange = numbers.stream()
                .allMatch(number -> Pattern.matches(Regex.ONETOFOURTYFIVE.getRegex(), number.toString()));

        if (!invalidRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+MINLOTTO+"부터 "+MAXLOTTO+" 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
