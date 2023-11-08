package lotto.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException.validateLottoAll(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }
}
