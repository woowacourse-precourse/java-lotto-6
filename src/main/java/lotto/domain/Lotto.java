package lotto.domain;

import static lotto.validation.LottoValidation.validate_lottoNum;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNums();
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoNums() {
        validate_lottoNum(numbers);
    }


    private void ascendingNumbers(){
        Collections.sort(numbers);
    }
}
