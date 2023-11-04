package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessage;

public class WinningNumbers extends Lotto{

    private BonusNumber bonusNumber;

    public WinningNumbers(String winningNumbers) {
        super(convertStringToList(winningNumbers));
    }

    private static List<Integer> convertStringToList(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_WINNING_NUMBER.getMessage());
        }
    }

    @Override
    protected String getNumbersCountErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_COUNT.getMessage();
    }

    @Override
    protected String getNumbersInRangeErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_IN_RANGE.getMessage();
    }

    @Override
    protected String getDuplicatedNumberErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_UNIQUE.getMessage();
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        validateDuplicatedBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedBonusNumber(BonusNumber bonusNumber) {
        if (this.containsNumber(bonusNumber.number())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_UNIQUE.getMessage());
        }
    }
}
