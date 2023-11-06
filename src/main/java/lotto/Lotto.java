package lotto;

import util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private final Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        changeIntegerToString(numbers);
    }

    private void changeIntegerToString(List<Integer> numbers) {
        String numberString = numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(numberString);
        validator.checkLottoStringInput(numberString);
        validator.checkLottoInput(numbers);
    }

    // TODO: 추가 기능 구현
}
