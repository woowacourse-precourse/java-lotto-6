package lotto.domain;

import static lotto.validator.Validator.validateMainNumbers;

import java.util.Collections;
import java.util.List;

public class MainNumbers {
    private final List<Integer> mainNumbers;

    public MainNumbers(List<Integer> mainNumbers) {
        validateMainNumbers(mainNumbers);
        this.mainNumbers = mainNumbers;
    }

    public boolean isMainNumber(int number) {
        return this.mainNumbers.contains(number);
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(this.mainNumbers);
    }
}
