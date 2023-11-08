package lotto.view.exception;

import lotto.view.message.exception.WinningLottoNumbersInputExceptionMessage;

public class WinningLottoNumbersInputException extends IllegalArgumentException {
    private WinningLottoNumbersInputException(
            final WinningLottoNumbersInputExceptionMessage winningLottoNumbersInputExceptionMessage) {
        super(winningLottoNumbersInputExceptionMessage.getMessage());
    }

    public static WinningLottoNumbersInputException of(
            final WinningLottoNumbersInputExceptionMessage winningLottoNumbersInputExceptionMessage) {
        return new WinningLottoNumbersInputException(winningLottoNumbersInputExceptionMessage);
    }
}
