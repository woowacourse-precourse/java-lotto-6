package lotto.model;

import lotto.constant.LottoConstant;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.VALID_LOTTO_NUMBER_NUM.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String getLottoNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number);
            if (number != numbers.get(numbers.size() - 1)) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}
