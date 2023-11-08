package lotto.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntToDoubleFunction;
import lotto.View.OutputView;
import lotto.constant.ErrorMessage;
import lotto.constant.GameNumber;
import lotto.domain.Lotto;

public class Validator {
    public boolean isAmountRight(String input) {
        try {
            int amount = Integer.parseInt(input);

            if (amount == 0 || !isDividedBy1000(amount)) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            OutputView.printError(ErrorMessage.AMOUNT_WRONG.getMessage());
            return false;
        }
    }

    private boolean isDividedBy1000(int amount) {
        if (amount % 1000 != 0)
            return false;

        return true;
    }

    public void checkWinningNumberRight(int number, List<Integer> list) {
        if (!isNumberInRange(number))
            throw new IllegalArgumentException();
        if (list.contains(number))
            throw new IllegalArgumentException();
    }

    private boolean isNumberInRange(int number) {
        if (number < GameNumber.MIN_NUMBER.getNumber() || number > GameNumber.MAX_NUMBER.getNumber())
            return false;

        return true;
    }

    public void checkBonusNumberRight(int number, Lotto winningNumber) {
        if (!isNumberInRange(number))
            throw new IllegalArgumentException();
        if (winningNumber.getNumbers().contains(number))
            throw new IllegalArgumentException();
    }
}
