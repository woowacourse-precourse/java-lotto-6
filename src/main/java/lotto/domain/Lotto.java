package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import lotto.util.GenerationUtil;
import lotto.util.ValidationUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationUtil.isValidWinNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    public static Lotto create() {
        return new Lotto(GenerationUtil.generateRandomNumbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String printNumbers() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        List<Integer> numbers = new ArrayList<>(getNumbers());
        Collections.sort(numbers);
        for (Integer number : numbers) {
            stringJoiner.add(String.valueOf(number));
        }
        return stringJoiner.toString();
    }

}
