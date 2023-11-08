package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.ErrorMessage;
import lotto.view.message.LottoGameMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public long validateCustomerMoneyInput(final String moneyInput) {
        try {
            return Long.parseLong(moneyInput);
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NOT_DIGIT_MONEY.errorMessage);
        }
    }

    public List<Integer> validateWinningNumberInput(final String winningNumberInput) {
        try {
            return Arrays.stream(winningNumberInput.split(DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NOT_DIGIT_WINNING_NUM.errorMessage);
        }
    }

    public int validateBonusNumberInput(final String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NOT_DIGIT_BONUS_NUM.errorMessage);
        }
    }

    public String requestLottoMoneyToBuy() {
        System.out.println(LottoGameMessage.BUY_LOTTO_MONEY.message);

        return Console.readLine();
    }

    public String requestWinningNumber() {
        System.out.println(LottoGameMessage.REQUEST_WINNING_NUMBER.message);

        return Console.readLine();
    }

    public String requestBonusNumber() {
        System.out.println(LottoGameMessage.REQUEST_BONUS_NUMBER.message);

        return Console.readLine();
    }
}
