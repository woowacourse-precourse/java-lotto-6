package lotto.template;

import lotto.constant.ErrorMessages;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberOperation implements Operation<WinningNumber> {
    @Override
    public WinningNumber execute() throws IllegalArgumentException {
        String winningNumber = InputView.WinningNumber();
        String[] splitWinningNumber = winningNumber.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        validateNumberType(splitWinningNumber, winningNumbers);
        return new WinningNumber(winningNumbers);
    }

    private static void validateNumberType(String[] splitWinningNumber, List<Integer> winningNumbers) {
        for (String number : splitWinningNumber) {
            try {
                int num = Integer.parseInt(number);
                winningNumbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                        ErrorMessages.INVALID_TYPE.getMessage() +
                        ErrorMessages.SUFFIX.getMessage());
            }
        }
    }
}
