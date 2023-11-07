package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.utils.ErrorMessage;
import lotto.utils.ErrorMessageUtil;

public class WinningNumberService {

    private final String SEPERATOR = ","; //상수로 관리하는 건 좋은데 이렇게 관리하는 게 맞나?
    private final int MAX_WINNING_NUMBERS = 17;

    public WinningNumbers createWinningNumbers() {
        WinningNumbers winningNumbers = null;
        boolean isCompleteToCreateWinningNumbers = false;

        while (!isCompleteToCreateWinningNumbers) {
            try {
                String inputWinningNumbers = Console.readLine();
                String[] splitWinningNumbers = splitInputWinningNumbers(inputWinningNumbers);

                winningNumbers = WinningNumbers.createWinningNumbers(splitWinningNumbers);
                isCompleteToCreateWinningNumbers = true;
            } catch (IllegalArgumentException exception) {
                System.out.print(ErrorMessageUtil.getOutputErrorMessage(exception.getMessage()));
            }
        }

        return winningNumbers;
    }

    //todo: 보너스 넘버랑 중복되는지 확인해야
    public WinningNumber createBonusNumber() {
        WinningNumber winningNumber = null;
        boolean isCompleteToCreateWinningNumber = false;

        while (!isCompleteToCreateWinningNumber) {
            try {
                String inputBonusNumber = Console.readLine();
                winningNumber = WinningNumber.createWinningNumber(inputBonusNumber);

                isCompleteToCreateWinningNumber = true;
            } catch (IllegalArgumentException exception) {
                System.out.print(ErrorMessageUtil.getOutputErrorMessage(exception.getMessage()));
            }
        }

        return winningNumber;
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
