package lotto.model;

import static lotto.configurations.ErrorMessages.*;
import static lotto.configurations.SettingValues.*;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public Boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }

    private void validate(List<Integer> winningNumbers) {
        validateSize(winningNumbers.size());
        List<Integer> confirmedNumbers = new ArrayList<>();
        for (Integer number : winningNumbers) {
            validateRange(number);
            validateDuplicateNumber(confirmedNumbers, number);

            confirmedNumbers.add(number);
        }
    }

    private void validateSize(Integer size) {
        if (size != SIZE_OF_LOTTO.get()) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + INVALID_SIZE_MESSAGE.get());
        }
    }

    private void validateDuplicateNumber(List<Integer> numberList, Integer number) {
        if (numberList.contains(number)) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + ALREADY_DRAWN_MESSAGE.get());
        }
    }

    private void validateRange(Integer number) {
        if (number < MIN_OF_RANGE.get() || number > MAX_OF_RANGE.get()) {
            throw new IllegalArgumentException(ERROR_HEADER.get() + OUT_OF_RANGE_NUMBER_MESSAGE.get());
        }
    }
}
