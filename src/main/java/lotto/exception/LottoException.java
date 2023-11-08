package lotto.exception;

import lotto.view.OutputView;

public class LottoException extends IllegalArgumentException {
	public LottoException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
		OutputView.printErrorMessage(errorMessage);
	}
}
