package lotto.domain.model;

import lotto.domain.validator.Validator;
import lotto.enums.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicateNumbers(numbers);

        this.numbers = Collections.unmodifiableList(sortNumbers(numbers));
    }

    private void validate(List<Integer> numbers) { // validate validateCountOfNumbers
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자의 개수가 6개를 넘지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void showNumbers() {
        System.out.println(this.numbers);
    }
}
