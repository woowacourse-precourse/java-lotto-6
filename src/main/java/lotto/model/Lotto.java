package lotto.model;

import lotto.view.InputView;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(InputView.ERROR_PROMPT + "로또 번호는 6개입니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(InputView.ERROR_PROMPT + "로또 번호는 중복을 허용하지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
