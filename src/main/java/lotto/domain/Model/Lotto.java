package lotto.domain.Model;

import lotto.domain.Utility.Constant;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException("로또 번호가 " + Constant.LOTTO_PICK_NUMBER + "개가 아닙니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
