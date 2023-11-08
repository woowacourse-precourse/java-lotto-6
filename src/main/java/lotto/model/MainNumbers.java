package lotto.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.common.Constant.LOTTO_NUMBERS_SIZE;
import static lotto.common.ExceptionMessage.ERROR_NUMBERS_DUPLICATE;
import static lotto.common.ExceptionMessage.ERROR_NUMBERS_SIZE_INCORRECT;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class MainNumbers {
    private final List<MainNumber> mainNumbers;

    private MainNumbers(List<MainNumber> mainNumbers) {
        validate(mainNumbers);
        this.mainNumbers = mainNumbers;
    }

    public static MainNumbers from(List<String> numbers) {
        return numbers.stream()
                .map(MainNumber::from)
                .sorted(Comparator.comparingInt(MainNumber::getMainNumber))
                .collect(collectingAndThen(toList(), MainNumbers::new));
    }

    private void validate(List<MainNumber> mainNumbers) {
        validateSize(mainNumbers);
        validateUnique(mainNumbers);
    }

    private void validateSize(List<MainNumber> mainNumbers) {
        if (hasOverSize(mainNumbers)) {
            throw new IllegalArgumentException(ERROR_NUMBERS_SIZE_INCORRECT);
        }
    }

    private boolean hasOverSize(List<MainNumber> mainNumbers) {
        return mainNumbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private void validateUnique(List<MainNumber> mainNumbers) {
        if (hasDuplicate(mainNumbers)) {
            throw new IllegalArgumentException(ERROR_NUMBERS_DUPLICATE);
        }
    }

    private boolean hasDuplicate(List<MainNumber> mainNumbers) {
        return mainNumbers.size() != new HashSet<>(mainNumbers).size();
    }

    public boolean hasNumber(int number) {
        return mainNumbers.stream()
                .anyMatch(mainNumber -> mainNumber.isNumberEqual(number));
    }

    public List<MainNumber> getMainNumbers() {
        return mainNumbers;
    }
}
