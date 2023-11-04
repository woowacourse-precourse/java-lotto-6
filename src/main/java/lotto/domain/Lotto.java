package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validation.LottoValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoValidation(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void lottoValidation(List<Integer> numbers) {
        LottoValidation.isLottoCorrect(numbers);
    }
    
    private List<Integer> sort(List<Integer> numbers) {
    	List<Integer> copy = new ArrayList<Integer>(numbers);
    	Collections.sort(copy);
    	return copy;
    }
    
    public List<Integer> getNumbers() {
    	return Collections.unmodifiableList(numbers);
    }
}
