package lotto.domain;

import lotto.validator.WinningNumValidator;

import java.util.List;

public class WinningNum {

    private final List<Integer> numbers;

    public WinningNum(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        WinningNumValidator validator = new WinningNumValidator(numbers);
    }

    public List<Integer> getWinningNum() {
        return this.numbers;
    }
}
