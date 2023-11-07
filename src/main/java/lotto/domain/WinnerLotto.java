package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;
import static lotto.constant.LottoConstant.RANGE_START_NUMBER;
import static lotto.constant.LottoConstant.RANGE_END_NUMBER;

import static lotto.exception.WinnerExceptionMessage.WRONG_WINNER_LOTTO_LENGTH;
import static lotto.exception.WinnerExceptionMessage.WRONG_WINNER_LOTTO_NUMBER_RANGE;
import static lotto.exception.WinnerExceptionMessage.DUPLICATED_WINNER_NUMBER;
import static lotto.exception.WinnerExceptionMessage.WRONG_BONUS_NUMBER_RANGE;
import static lotto.exception.WinnerExceptionMessage.DUPLICATED_NUMBER_BETWEEN_WINNER_NUMBER_AND_BONUS_NUMBER;


public class WinnerLotto {

    private final List<Integer> winnerNumbers;
    private final Integer bonusNumber;

    private WinnerLotto(final List<Integer> winnerNumbers,
                       final Integer bonusNumber) {
        validateWinnerNumbersLength(winnerNumbers);
        validateEachWinnerNumberRange(winnerNumbers);
        validateDuplicatedNumber(winnerNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerLotto create(final List<Integer> winnerNumbers,
                                     final Integer bonusNumber) throws IllegalArgumentException {
        return new WinnerLotto(winnerNumbers,
                               bonusNumber);
    }

    private void validateWinnerNumbersLength(final List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException(WRONG_WINNER_LOTTO_LENGTH.getMessage());
        }
    }

    private void validateEachWinnerNumberRange(final List<Integer> winnerNumbers) {
        if (winnerNumbers.stream()
                .anyMatch(number -> !(RANGE_START_NUMBER.getSetting() <= number && number <= RANGE_END_NUMBER.getSetting()))) {
            throw new IllegalArgumentException(WRONG_WINNER_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicatedNumber(final List<Integer> winnerNumbers) {
        if (winnerNumbers.stream()
                .collect(Collectors.toSet())
                .size()
                != LOTTO_LENGTH.getSetting()) {
            throw new IllegalArgumentException(DUPLICATED_WINNER_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberRange(final Integer bonusNumber) {
        if (!(RANGE_START_NUMBER.getSetting() <= bonusNumber && bonusNumber <= RANGE_END_NUMBER.getSetting())) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicatedNumberBetweenWinnerNumbersAndBonusNumber(final List<Integer> winnerNumbers,
                                                                            final Integer bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_BETWEEN_WINNER_NUMBER_AND_BONUS_NUMBER.getMessage());
        }
    }


    public List<Integer> getWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }


}
