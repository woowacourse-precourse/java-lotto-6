package lotto.model;

import static lotto.util.Validate.validateDuplication;
import static lotto.util.Validate.validateRange;
import static lotto.util.Validate.validateSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.RandomNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> generator(int count) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> number = RandomNumber.generate();
            Collections.sort(number);

            result.add(new Lotto(number));
        }
        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

}
