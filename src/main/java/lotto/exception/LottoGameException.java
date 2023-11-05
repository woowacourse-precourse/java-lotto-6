package lotto.exception;

import static lotto.view.OutputView.notifyErrorMessage;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameException extends IllegalArgumentException {

    private LottoGameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        notifyErrorMessage(errorMessage.getMessage());
        Console.close();
    }

    public static LottoGameException of(ErrorMessage errorMessage) {
        return new LottoGameException(errorMessage);
    }

}
