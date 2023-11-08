package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_DUPLICATED;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_WRONG_COUNT;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.views.ErrorOutput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorOutput.printErrorMessage(LOTTO_NUMBER_WRONG_COUNT);
            throw new IllegalArgumentException(LOTTO_NUMBER_WRONG_COUNT);
        }
        if (isContainsDuplicatedNumber(numbers)) {
            ErrorOutput.printErrorMessage(LOTTO_NUMBER_DUPLICATED);
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED);
        }
        if (!isNumbersInRange(numbers)) {
            ErrorOutput.printErrorMessage(LOTTO_NUMBER_OUT_OF_RANGE);
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    // TODO: 추가 기능 구현
    private boolean isContainsDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }
}
