package lotto.model;

import static lotto.constant.Constant.LOTTO_SIZE;
import static lotto.constant.Constant.MAX_LOTTO_NUMBER;
import static lotto.constant.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_CAN_NOT_BE_DUPLICATE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_SIZE_IS_SIX;

import java.util.Collections;
import java.util.List;
import lotto.exception.ErrorInputException;

public class WinnerNumber {
    private final List<Integer> winnerNumbers;

    private WinnerNumber(List<Integer> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
        validate();
        isDuplicate();
        isBetweenOneAndFortyFive();
    }

    public static WinnerNumber createWinnerNumber(List<Integer> winnerNumbers) {
        return new WinnerNumber(winnerNumbers);
    }

    public List<Integer> getWinnerNumbers() {
        return Collections.unmodifiableList(winnerNumbers);
    }

    private void validate() {
        if (winnerNumbers.size() != LOTTO_SIZE) {
            throw new ErrorInputException(WINNER_NUMBER_SIZE_IS_SIX);
        }
    }

    private void isDuplicate() {
        long countDistinct = winnerNumbers.stream().distinct().count();
        if (countDistinct < winnerNumbers.size()) {
            throw new ErrorInputException(WINNER_NUMBER_CAN_NOT_BE_DUPLICATE);
        }
    }

    private void isBetweenOneAndFortyFive() {
        boolean allBetweenOneAndFortyFive = winnerNumbers.stream()
                .allMatch(integer -> integer >= MIN_LOTTO_NUMBER && integer <= MAX_LOTTO_NUMBER);
        if (!allBetweenOneAndFortyFive) {
            throw new ErrorInputException(WINNER_NUMBER_IS_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }
}
