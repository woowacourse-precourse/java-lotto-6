package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validate.LottoValidate;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = sort(numbers);
        LottoValidate.validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
