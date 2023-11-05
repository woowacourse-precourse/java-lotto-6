package lotto.model;

import lotto.utils.Constants;
import lotto.utils.message.ErrorMessage;
import lotto.utils.Util;
import java.util.List;

public class WinningNumber {

    private Lotto winningNumber;
    private int bonusNumber;

    private WinningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber from(String[] inputNumbers, int bonusNumber) {
        List<Integer> numbers = Util.stringToIntegerList(inputNumbers);
        Lotto winningNumber = new Lotto(numbers);
        validateDuplicatedNumber(winningNumber, bonusNumber);
        validateNumberRange(bonusNumber);
        return new WinningNumber(winningNumber, bonusNumber);
    }

    private static void validateDuplicatedNumber(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private static void validateNumberRange(int number) {
        if (number < Constants.MIN_LOTTO_NUMBER || number > Constants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.getMessage());
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
