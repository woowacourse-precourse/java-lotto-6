package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static final String ERROR_LOTTO_NUMBER_COUNT_MESSAGE = "[ERROR] 당첨 번호는 쉼표로 구분된 여섯개의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 당첨 번호는 1이상 45이하의 숫자여야 합니다.";
    public static final String ERROR_LOTTO_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않은 여섯개의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBERS_LENGTH.get()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH.get());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LottoConstant.MIN_LOTTO_NUMBER.get() ||
                        number > LottoConstant.MAX_LOTTO_NUMBER.get())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.get());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE.get());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    // TODO: 추가 기능 구현
}
