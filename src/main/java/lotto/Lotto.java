package lotto;

import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compare(List<Integer> _winning) {
        List<Integer> _same = getNumbers().stream().filter(
                _number -> {
                    return _winning.contains(_number);
                }).toList();
        return _same.size();
    }
}
