package lotto.domain;

import lotto.utils.GameRules;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요.";
    private static final String INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복된 번호가 존재합니다.";
    private static final String INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1~45 범위 내 번호를 입력해주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateLottoNumberRange(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (lotto.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < GameRules.START_RANGE.getValue() || number > GameRules.END_RANGE.getValue())) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumber() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return "" + numbers + "";
    }
}