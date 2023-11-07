package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.utils.ErrorMessage;

public class WinningNumberService {

    private final String SEPERATOR = ","; //상수로 관리하는 건 좋은데 이렇게 관리하는 게 맞나?
    private final int MAX_WINNING_NUMBERS = 17;

    public WinningNumbers createWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        String[] splitWinningNumbers = splitInputWinningNumbers(inputWinningNumbers);

        return WinningNumbers.createWinningNumbers(splitWinningNumbers);
    }

    public WinningNumber createBonusNumber() {
        String inputBonusNumber = Console.readLine();

        return WinningNumber.createWinningNumber(inputBonusNumber);
    }

    private String[] splitInputWinningNumbers(String inputWinningNumbers) {
        validateInputNumbersSize(inputWinningNumbers);

        return inputWinningNumbers.split(SEPERATOR);
    }

    private void validateInputNumbersSize(String inputWinningNumbers) {
        if (inputWinningNumbers.length() > MAX_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_TOO_LONG.getErrorMessage());
        }
    }

}
