package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int minNumber = 1;
    private final int maxNumber = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        rangeValidate(numbers);

    }

    // TODO: 추가 기능 구현
    private void rangeValidate(List<Integer> numbers){

    }
}
