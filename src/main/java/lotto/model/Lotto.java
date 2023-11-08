package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.validator.Validation.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkInRange(numbers);
        checkDuplication(numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> lottoNumber = new ArrayList<>(numbers);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}