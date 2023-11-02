package lotto.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.IllegalDuplicateException;
import lotto.exception.IllegalRangeException;
import lotto.exception.IllegalSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateNumberIsDuplicate(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalSizeException();
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalRangeException();
            }
        }
    }

    private static void validateNumberIsDuplicate(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalDuplicateException();
            }
        }
    }

    public List<Integer> getNumbers(){
        return new ArrayList<>(numbers);
    }

}
