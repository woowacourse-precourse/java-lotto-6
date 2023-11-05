package lotto.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.exception.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.VALIDATOR.getLottoValidator().sizeValidate(numbers);
        Validator.VALIDATOR.getLottoValidator().duplicatedValidation(numbers);
        this.numbers = new ArrayList<>(numbers); // numbers 리스트를 복사하여 새로운 ArrayList 생성
        Collections.sort(this.numbers);
    }

    // TODO: 추가 기능 구현
}
