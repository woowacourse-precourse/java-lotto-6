package lotto;

import java.util.List;
import lotto.validation.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputException.notSixNumberInput(numbers);
        InputException.numberDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printLottoNumber() {
        System.out.println(numbers);
    }
}
