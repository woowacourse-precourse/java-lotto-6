package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[Error] 올바른 값을 입력해주세요");
        }
    }
    public void showLottoNumbers() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}