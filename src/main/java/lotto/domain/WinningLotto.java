package lotto.domain;


import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;

import java.util.List;

import static lotto.utils.constants.WinningLottoConstants.*;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> userNumbers) {
        if (userNumbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new InvalidInputException(SIZE_NOT_VALID_MESSAGE);
        }
        if (userNumbers.stream().distinct().count() != REQUIRED_NUMBER_COUNT) {
            throw new DuplicateInputException();
        }
        if (userNumbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new InvalidInputException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    public Integer countNumbers(Lotto lotto) {
        Integer matchingNumbers = 0;

        for (Integer numbers : lotto.getNumbers()) {
            if (winningNumbers.contains(numbers)) {
                matchingNumbers ++;
            }
        }

        return matchingNumbers;
    }

    public Boolean isCorrectBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
