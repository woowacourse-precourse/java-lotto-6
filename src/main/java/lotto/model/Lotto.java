package lotto.model;

import lotto.enums.ErrorMsg;
import lotto.enums.LottoNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_COUNT.getErrMsg());
        }
        if (numbers.stream().distinct().count() != LottoNumber.COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_DUPLICATE.getErrMsg());
        }
        if (numbers.stream().anyMatch(number -> LottoNumber.isOutOfRange(number))) {
            throw new IllegalArgumentException(ErrorMsg.INVALID_LOTTO_NUMBER_RANGE.getErrMsg());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isContainBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
