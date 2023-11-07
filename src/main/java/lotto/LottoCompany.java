package lotto;

import lotto.exception.ErrorMessage;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.ui.SystemMessage;

public class LottoCompany {

	private Lotto answerLotto;
	private Integer bonusNumber;

	public static LottoCompany newInstance() {
		return new LottoCompany();
	}

	private LottoCompany() {
	}

	public void drawLotto() {
		drawLottoNumbers();
		drawBonusNumber();
	}

	private void drawLottoNumbers() {
		while (true) {
			try {
				answerLotto = Lotto.of(
						Input.integerList(SystemMessage::inputLottoNumbers));
				return;
			} catch (IllegalArgumentException e) {
				Output.output(e::getMessage);
			}
		}
	}

	private void drawBonusNumber() {
		while (true) {
			try {
				bonusNumber = Input.integer(SystemMessage::inputBonusNumber);
				validateBonusNumber(bonusNumber);
				return;
			} catch (IllegalArgumentException e) {
				Output.output(e::getMessage);
			}
		}
	}

	private void validateBonusNumber(int bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
		}
		if (answerLotto.getNumbers().contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
		}
	}

	public void respondLottoResult(User user) {
		LottoResults lottoResults = user.matchLottos(answerLotto, bonusNumber);
		user.calculatePrize(lottoResults);
	}
}
