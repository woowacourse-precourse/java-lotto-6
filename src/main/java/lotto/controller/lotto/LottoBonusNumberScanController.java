package lotto.controller.lotto;

import lotto.controller.input.InputController;
import lotto.controller.validation.bonus.LottoBonusNumberValueValidator;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBonus;
import lotto.view.MessageOutputView;

public class LottoBonusNumberScanController {

	MessageOutputView messageOutputView = new MessageOutputView();
	InputController inputController = new InputController();
	LottoBonusNumberValueValidator lottoBonusNumberValueValidator = new LottoBonusNumberValueValidator();

	public void scanLottoBonusNumber(Lotto lotto, LottoBonus lottoBonus) {
		try {
			messageOutputView.printScanningLottoBonusNumberMessage();
			String scannedLottoBonusNumberString = inputController.scanLottoNumberBonusString();
			lottoBonusNumberValueValidator.checkValidationOfLottoBonusNumber(lotto,
				scannedLottoBonusNumberString);
			Integer scannedLottoBonusNumber = Integer.parseInt(scannedLottoBonusNumberString);
			lottoBonus.setLottoBonusNumber(scannedLottoBonusNumber);
		} catch (IllegalArgumentException illegalArgumentException) {
			scanLottoBonusNumber(lotto, lottoBonus);
		}

	}
}
