package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMsg());
        }
    }

    public void printNumbers(){
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
