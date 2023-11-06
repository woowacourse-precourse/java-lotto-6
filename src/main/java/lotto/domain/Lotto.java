package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_NUMBER_OVER_MAX;
import static lotto.constants.LottoConstants.LOTTO_SIZE_MAX_LENGTH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = numbers;
        validateLottoSizeCheck(numbers);
        validateLottoDuplicate(numbers);
        validateLottoNumberOverMax(numbers);
    }

    private void validateLottoSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.LOTTO_NUMBERS_SIZE_MAX.getMsg());
        }
    }

    private void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> duplicates = new HashSet<>(numbers);
        if (duplicates.size() != LOTTO_SIZE_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    private void validateLottoNumberOverMax(List<Integer> numbers) {
        if (isInvalidLottoNumber(numbers)) {
            throw new UserInputException(ErrorMsg.LOTTO_NUMBER_OVER_MAX.getMsg());
        }
    }

    private boolean isInvalidLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > LOTTO_NUMBER_OVER_MAX);
    }
}
