package lotto.model;

import lotto.utils.ValidateCheck;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidateCheck.numberCountValidate(numbers);
        ValidateCheck.numberDupulicationValidate(numbers);
        this.numbers = numbers;
    }


    // TODO: 추가 기능 구현
}
