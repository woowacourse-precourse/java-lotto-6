package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final int minNumber = 1;
    private final int maxNumber = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValidate(numbers);
        overlapValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            new ThrowNewException().sizeException();
        }
    }

    // TODO: 추가 기능 구현
    private void rangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > maxNumber || number < minNumber) {
                new ThrowNewException().rangeException();
            }
        }
    }

    private void overlapValidate(List<Integer> numbers){
        Set<Integer> overlapValidate = new HashSet<>();
        for (int number : numbers) {
            if(!overlapValidate.add(number)){
                new ThrowNewException().overlapException();
            }
        }
    }
}
