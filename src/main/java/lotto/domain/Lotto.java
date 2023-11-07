package lotto.domain;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.config.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkNumberInRange(numbers);
        hasSameNumber(numbers);
        this.numbers = numbers;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIZE_INCORRECT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }

    private void checkNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConfig.MIN_LOTTO_NUMBER || number > LottoConfig.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
            }
        }
    }

    private void hasSameNumber(List<Integer> numbers) {
        List<Integer> checkDuplication = numbers.stream().distinct().toList();
        if (numbers.size() != checkDuplication.size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }
}
