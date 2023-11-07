package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.validator.Validator;

public class MainNumbers {
    private final List<Integer> mainNumbers;

    public MainNumbers(List<Integer> mainNumbers) {
        Validator.validateMainNumbers(mainNumbers);
        this.mainNumbers = mainNumbers;
    }

    public boolean isMainNumber(int number) {
        return this.mainNumbers.contains(number);
    }

    public List<Integer> toList() {
        return Collections.unmodifiableList(this.mainNumbers);
    }

}
