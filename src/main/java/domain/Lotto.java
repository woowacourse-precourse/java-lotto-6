package domain;

import validator.LottoValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        LottoValidator.validSize(numbers);
        LottoValidator.validDuplcate(numbers);
        LottoValidator.validRange(numbers);
    }

    @Override
    public String toString(){
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        return sortedNumbers.toString();
    }

}
