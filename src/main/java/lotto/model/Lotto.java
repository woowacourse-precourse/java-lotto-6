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

    public List<Integer> getNumbers(){
        return numbers;
    }
}
