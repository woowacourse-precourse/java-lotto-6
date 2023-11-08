package lotto.model;

import java.util.List;
import java.util.Collections;
import java.util.Set;

import lotto.view.ErrorMessage;
import lotto.view.Input;

import java.util.HashSet;

public class Lotto {
    private List<Integer> numbers;
    private final int MIN_NUM = 1;
    private final int MAX_NUM = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public int show(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        validate_Size(numbers);
        validate_Duplicate(numbers);
        validate_Range(numbers);
    }

    public void validate_Size(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            ErrorMessage.count_Error();
            throw new IllegalArgumentException();
        }
    }

    public void validate_Duplicate(List<Integer> numbers) throws IllegalArgumentException {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }
        if (set.size() != numbers.size()) {
            ErrorMessage.duplicate_Error();
            throw new IllegalArgumentException();
        }

    }

    public void validate_Range(List<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < MIN_NUM || numbers.get(i) > MAX_NUM) {
                ErrorMessage.range_Error();
                throw new IllegalArgumentException();
            }
        }

    }

    public void validate_Bonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            ErrorMessage.duplicate_Error();
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }
}
