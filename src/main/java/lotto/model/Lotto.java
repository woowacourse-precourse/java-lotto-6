package lotto.model;

import static java.util.function.Predicate.isEqual;
import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.NOT_IN_LOTTO_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;
import lotto.constant.LottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateUniqueNumbers(numbers);
        validateNumberInLottoNumberRange(numbers);
    }

    public static Lotto create() {
        return new Lotto(pickNumbers());
    }

    private void validateUniqueNumbers(final List<Integer> pickedNumbers) {
        Objects.requireNonNull(pickedNumbers);
        if (hasDuplicatedNumber(pickedNumbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicatedNumber(final List<Integer> pickedNumbers) {
        Objects.requireNonNull(pickedNumbers);
        return pickedNumbers.stream()
                .distinct()
                .toList()
                .size() != pickedNumbers.size();
    }

    private void validateNumberInLottoNumberRange(final List<Integer> pickedNumbers) {
        Objects.requireNonNull(pickedNumbers);
        if (hasNumberNotInLottoNumberRange(pickedNumbers)) {
            throw new IllegalArgumentException(NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean hasNumberNotInLottoNumberRange(final List<Integer> pickedNumbers) {
        Objects.requireNonNull(pickedNumbers);
        return pickedNumbers.stream()
                .anyMatch(LottoNumber.RANGE::notInclude);
    }

    private static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LottoNumber.RANGE.getStartNumber(),
                        LottoNumber.RANGE.getEndNumber(),
                        LottoNumber.RANGE.getCount()
                ).stream()
                .sorted()
                .toList();
    }

    public int compareTo(final List<Integer> winningNumbers) {
        Objects.requireNonNull(winningNumbers);
        return (int) numbers.stream()
                .filter(number -> winningNumbers.stream()
                        .anyMatch(isEqual(number)))
                .count();
    }

    public boolean matchesBonusNumber(final int bonusNumber) {
        return numbers.stream()
                .anyMatch(isEqual(bonusNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
