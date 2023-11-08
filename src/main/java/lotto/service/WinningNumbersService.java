package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumbers;
import lotto.utils.ErrorMessage;

public class WinningNumbersService extends CreateService {

    private final String SEPERATOR = ",";
    private final int MAX_WINNING_NUMBERS = 17;

    public WinningNumbers createWinningNumbers() {
        Object winningNumbers = this.create();

        return (WinningNumbers) winningNumbers;
    }

    @Override
    public Object createObject(Object... inputs) {
        String inputWinningNumbers = Console.readLine();
        String[] splitWinningNumbers = splitInputWinningNumbers(inputWinningNumbers);

        return WinningNumbers.createWinningNumbers(splitWinningNumbers);
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
