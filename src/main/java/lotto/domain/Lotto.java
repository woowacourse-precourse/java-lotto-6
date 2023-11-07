package lotto.domain;

import lotto.utils.Parser;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return Parser.intListToString(numbers);
    }
}
