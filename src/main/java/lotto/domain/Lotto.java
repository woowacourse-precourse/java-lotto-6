package lotto.domain;

import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersRange(numbers);
        validateLottoNumbersDuplicate(numbers);
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBERS_COUNT) {
            throw new InvalidInputException(ErrorMessage.WRONG_LOTTO_NUMBERS_COUNT);
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstant.LOTTO_NUMBER_MIN || number > LottoConstant.LOTTO_NUMBER_MAX) {
                throw new InvalidInputException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    private void validateLottoNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConstant.LOTTO_NUMBERS_COUNT) {
            throw new InvalidInputException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE);
        }
    }

    public int match(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
