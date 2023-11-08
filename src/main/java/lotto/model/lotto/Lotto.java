package lotto.model.lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return Collections.unmodifiableList(sortedNumbers);
    }


}
