package domain;

import static config.ErrorMessage.*;
import static config.LottoConst.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import exception.InputException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = removeDuplication(numbers);
        validateInRange(numbers);
        validateSize(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private List<Integer> removeDuplication(List<Integer> numbers) {
        Set<Integer> lottoSet = new HashSet<>(numbers);
        return new ArrayList<>(lottoSet);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(LOTTO.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        for (int number : numbers) {
            InputException.validateRange(number);
        }
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int compareLotto(Lotto lotto) {
        Set<Integer> orignLotto = new HashSet<>(numbers);
        int count = COUNT_INIT.getNumber();
        for (Integer number : lotto.numbers) {
            if (orignLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
