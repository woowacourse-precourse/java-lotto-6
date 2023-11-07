package lotto.domain;

import lotto.validator.NumberValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        NumberValidator.validateLottoDuplication(numbers);
        NumberValidator.validateLottoNumberRange(numbers);
        NumberValidator.validateLength(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumbers(List<Integer> winningLottoNumbers) {
        int cnt = 0;
        for (Integer winningLottoNumber : winningLottoNumbers) {
            if (numbers.stream().anyMatch(number -> number.equals(winningLottoNumber))) {
                cnt++;
            }
        }
        return cnt;
    }
}
