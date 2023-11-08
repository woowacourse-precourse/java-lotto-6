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
    public Object createObject(final Object... inputs) {
        String inputWinningNumbers = Console.readLine();
        validateInputNumbersSize(inputWinningNumbers);

        String[] splitWinningNumbers = splitInputWinningNumbers(inputWinningNumbers);

        return WinningNumbers.createWinningNumbers(splitWinningNumbers);
    }

    private String[] splitInputWinningNumbers(String inputWinningNumbers) {
        return inputWinningNumbers.split(SEPERATOR);
    }

    private void validateInputNumbersSize(final String inputWinningNumbers) {
        if (inputWinningNumbers.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());
        }

        if (inputWinningNumbers.length() > MAX_WINNING_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_TOO_LONG.getErrorMessage());
        }
    }
}
