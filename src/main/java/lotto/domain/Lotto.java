package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Validator.LottoValidator;
import lotto.Validator.NumberValidator;
import lotto.util.Parser;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Lotto(String input) {
        List<Integer> numbers = Parser.toIntegerList(input);
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.isUnvalidLength(numbers);
        LottoValidator.isDuplicated(numbers);
        for (int num : numbers) {
            NumberValidator.isWrongType(String.valueOf(num));
            NumberValidator.isNegative(num);
            NumberValidator.isOutRange(num);
        }
    }

    public int compareNumbers(List<Integer> numbers) {
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        numbersCopy.retainAll(this.numbers);
        return numbersCopy.size();
    }

    public boolean compareOneNumber(int number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
