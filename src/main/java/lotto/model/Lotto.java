package lotto.model;

import java.util.List;
import lotto.view.message.Error;

public class Lotto {
    public static final Integer PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkOversize(numbers);
        this.numbers = numbers;
    }

    private void checkOversize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OVERSIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }
}
