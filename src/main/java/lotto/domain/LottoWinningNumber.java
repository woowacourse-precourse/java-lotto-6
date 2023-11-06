package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.exception.ExceptionMessage;

public class LottoWinningNumber {

    private List<Integer> numbers;

    public LottoWinningNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>();

        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);

        for (int number : numbers) {
            validNumber(number);
            this.numbers.add(number);
        }
        this.numbers = numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_DUPLICATED);
        }
    }


    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void validNumber(int number) {
        if (number < LottoConstant.LOTTO_START_NUMBER || number > LottoConstant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_OUT_OF_BOUND);
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}
