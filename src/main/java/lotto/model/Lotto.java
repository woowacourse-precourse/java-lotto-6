package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_NUMBERS_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int AMOUNT_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateNumbersDuplicated(numbers);
        validateNumbersAmount(numbers);
        validateIsNumberInCorrectRange(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto generateRandomLottoNumbers() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, AMOUNT_OF_NUMBERS);
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
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
        if (numbers.size() != AMOUNT_OF_NUMBERS) {
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
        return lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
