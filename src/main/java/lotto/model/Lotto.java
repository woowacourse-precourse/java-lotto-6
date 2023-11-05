package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void sortAscending() {
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer countMatchNumber(Lotto lotto) {
        List<Integer> copyOfLotto = new ArrayList<>(lotto.getNumbers());
        copyOfLotto.retainAll(numbers);
        return copyOfLotto.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }
}
