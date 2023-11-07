package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.util.Validator;

public class Lotto {

    //numbers만 받고 추가번호는 받지 않는다 - 단일책임원칙
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        Arrays.sort(numbers.toArray());
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
