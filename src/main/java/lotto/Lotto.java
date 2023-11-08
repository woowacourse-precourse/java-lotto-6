package lotto;

import lotto.handler.ExceptionHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            lottoValidate(numbers);
            this.numbers = numbers;
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handle(e);
        }

    }

    public void lottoValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Lottery number size must be 6. \n └─ errorVar : " + numbers.size());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("There are duplicate numbers on lottery list. \n └─ errorVar : " + numbers);
        }
    }
}
