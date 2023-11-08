package lotto.domain;

import java.util.List;
import lotto.exception.game.OutOfRangeException;
import lotto.exception.game.OverlapBonusNumberException;
import lotto.exception.lotto.NonNumberFormatException;
import lotto.util.Utils;

public class Game {
    private static final String ONLY_NUMBER_REGEX = "[0-9]+";
    private Lotto winningNumbers;
    private int bonusNumber;

    public Game(String winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = new Lotto(Utils.stringToIntegerList(winningNumbers));
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getNumbers();
    }

    public void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Utils.stringToInt(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateWinningNumbers(String winningNumbers) {
        validateNumberFormat(winningNumbers);
    }

    private void validateNumberFormat(String input) {
        if (!input.replace(",", "").matches(ONLY_NUMBER_REGEX)) {
            throw new NonNumberFormatException();
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        validateNumberFormat(bonusNumber);

        int parsedBonusNumber = Utils.stringToInt(bonusNumber);
        validateOverlapToWinningNumber(parsedBonusNumber);
    }

    private void validateOverlapToWinningNumber(int bonusNumber) {
        if (this.getWinningNumbers().contains(bonusNumber)) {
            throw new OverlapBonusNumberException();
        }
    }

    private void validateOutOfRangeNumber(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new OutOfRangeException();
        }
    }
}
