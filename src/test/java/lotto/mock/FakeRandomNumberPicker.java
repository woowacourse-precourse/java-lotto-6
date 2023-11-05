package lotto.mock;

import java.util.List;
import lotto.domain.randomnumber.RandomNumberPicker;

public class FakeRandomNumberPicker implements RandomNumberPicker {

    private final List<Integer> numbers;

    public FakeRandomNumberPicker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> pickSixUniqueNumbersInRange(int startInclusive, int endInclusive) {
        return this.numbers;
    }

}
