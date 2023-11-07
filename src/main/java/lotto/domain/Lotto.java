package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.Validator.LottoValidator;
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
            LottoValidator.isInRange(num);
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
