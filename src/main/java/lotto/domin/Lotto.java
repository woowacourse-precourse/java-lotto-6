package lotto.domin;

import lotto.view.ExceptionMessage;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NotDuplication(numbers);
        numbers.stream().forEach(i -> Exception.overNumber(i));
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void NotDuplication(List<Integer> numbers) throws IllegalArgumentException{
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_OVERLAP.getExceptionValue());
                }
            }
        }
    }


}
