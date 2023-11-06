package lotto.Domain;

import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Dictionary.LottoDictionary.*;
import static lotto.Message.ExceptionMessage.LottoExceptionMessage.*;

import java.util.List;
import lotto.Exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        for (Integer number : numbers) {
            isValidLottoNumber(number);
        }
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE.getValue()) {
            throw new LottoException(LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE.getValue()) {
            throw new LottoException(LOTTO_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }
}