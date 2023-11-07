package lotto.model;

import lotto.constant.LottoNumConstant;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumConstant.VALID_LOTTO_NUMBER_NUM.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String getLottoNumbers() {
        return String.format("[%s]\n", String.join(", ", numbers.stream().map(String::valueOf).toList()));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
