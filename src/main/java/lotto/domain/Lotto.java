package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private static final String EXIST_REPETITION_LOTTO_NUMBER = "[ERROR] 중복된 로또 번호가 있습니다.";

    private static final String RANGE_FOR_ONE_TO_FOURTYFIVE = "[ERROR] 로또번호는 1~45 사이의 수이어야 합니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = ascendingSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkEmpty(numbers);
        checkNumbersCount(numbers);
        checkDuplicateNumbers(numbers);
        checkNumbersRange(numbers);
    }

    private void checkEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호가 비어 있습니다.");
        }
    }

    private void checkNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 당첨 번호는 " + WinningNumbers.WINNING_NUMBER_COUNT + "개 입력해야 합니다.");
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> removeDuplicateNumbers = new HashSet<>(numbers);
        if (removeDuplicateNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(EXIST_REPETITION_LOTTO_NUMBER);
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::checkNumbersRange);
    }

    private void checkNumbersRange(int number) {
        if (!(LottoMachine.LOTTO_MIN_NUMBER <= number && number <= LottoMachine.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(RANGE_FOR_ONE_TO_FOURTYFIVE);
        }
    }

    private List<Integer> ascendingSort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto other) {
        Set<Integer> matchNumbers = new HashSet<>(this.numbers);
        matchNumbers.retainAll(other.numbers);
        return matchNumbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
