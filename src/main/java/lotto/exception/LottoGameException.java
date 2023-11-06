package lotto.exception;

import static lotto.view.OutputView.notifyErrorMessage;

public class LottoGameException extends IllegalArgumentException {

    private LottoGameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        notifyErrorMessage(errorMessage.getMessage());
    }

    public static LottoGameException of(ErrorMessage errorMessage) {
        return new LottoGameException(errorMessage);
    }

}
