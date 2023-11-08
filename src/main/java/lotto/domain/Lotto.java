package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


}
