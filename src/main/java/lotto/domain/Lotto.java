package lotto.domain;

import static lotto.util.Util.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkNumberRange(numbers);
        checkDuplication(numbers);
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_SIZE);
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < START_RANGE || number > END_RANGE)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_RANGE);
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_NUMBER_DUPLICATION);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public Lotto ascendingSort() {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        return new Lotto(sortedNumbers);
    }

    public Rank getRankResult(WinningLotto winningLotto) {
        return winningLotto.match(this);
    }

    public static int getLottoCount(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }
}
