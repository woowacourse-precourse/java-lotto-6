package lotto.model;

import lotto.controller.exception.Exception;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        Exception.lotto(numbers);
        this.numbers = numbers;
    }
}
