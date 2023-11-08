package lotto.domain;

import lotto.validator.system.domain.LottoValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = orderLotto(numbers);
    }

    public String toStringForDisplay(){
        return numbers.toString();
    }

    private List<Integer> orderLotto(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
