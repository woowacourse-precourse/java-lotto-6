package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.*;
import static lotto.exception.LottoExceptionMessage.*;

public class WinnerLotto {

    private final List<Integer> winnerNumbers;
    private final Integer bonusNumber;

    public WinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        validateWinnerNumbersLength(winnerNumbers);
        validateEachWinnerNumberRange(winnerNumbers);
        validateDuplicatedNumber(winnerNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinnerNumbersLength(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachWinnerNumberRange(List<Integer> winnerNumbers) {
        if (winnerNumbers.stream()
                .anyMatch(number -> !(RANGE_START_NUMBER.getSetting() <= number && number <= RANGE_END_NUMBER.getSetting()))) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumber(List<Integer> winnerNumbers) {
        if (winnerNumbers.stream()
                .collect(
                        Collectors.toSet()
                )
                .size()
                != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (!(RANGE_START_NUMBER.getSetting() <= bonusNumber && bonusNumber <= RANGE_END_NUMBER.getSetting())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(List<Integer> winnerNumbers,
                                                                            Integer bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }


}
