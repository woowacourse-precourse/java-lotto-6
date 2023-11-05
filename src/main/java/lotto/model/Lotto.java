package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBERS_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.AMOUNT_OF_NUMBERS;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateNumbersDuplicated(numbers);
        validateNumbersAmount(numbers);
        validateIsNumberInCorrectRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateNumbersDuplicated(List<Integer> numbers) {
        long deduplicatedCount = numbers.stream()
                .distinct()
                .count();
        if (deduplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.toString());
        }
    }

    private void validateNumbersAmount(List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_NUMBERS.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_AMOUNT.toString());
        }
    }

    private void validateIsNumberInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isNumberInCorrectRange(number)) {
                throw new IllegalArgumentException(NOT_IN_RANGE_LOTTO_NUMBER.toString());
            }
        }
    }

    private boolean isNumberInCorrectRange(int lottoNumber) {
        return lottoNumber < MIN_LOTTO_NUMBER.getValue()
                || lottoNumber > MAX_LOTTO_NUMBER.getValue();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
