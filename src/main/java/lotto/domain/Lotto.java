package lotto.domain;

import lotto.util.ErrorConstant;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void isDuplicated(List<Integer> tmp){
        List<Integer> distinctNumbers = tmp.stream()
                .distinct()
                .collect(Collectors.toList());

        if(distinctNumbers.size()!=tmp.size()){
            throw new IllegalArgumentException(ErrorConstant.DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}