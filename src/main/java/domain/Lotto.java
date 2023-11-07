package domain;

import domain.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        LottoValidator.checkLottoValidation(numbers);
        this.numbers.addAll(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }
}
