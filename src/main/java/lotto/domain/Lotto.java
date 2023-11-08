package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validation.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
        ArrayList<Integer> validNumbers = new ArrayList<>(numbers);
        Collections.sort(validNumbers);
        this.numbers = validNumbers;
    }

    // TODO: 추가 기능 구현
}
