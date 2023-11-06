package lotto;

import lotto.variables.ErrorMessages;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUM_ERROR.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString(){
        return numbers.toString();
    }
}
