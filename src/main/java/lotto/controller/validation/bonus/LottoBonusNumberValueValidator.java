package lotto.controller.validation.bonus;

import lotto.model.lotto.Lotto;
import lotto.view.ErrorOutputView;

public class LottoBonusNumberValueValidator {
	ErrorOutputView errorOutputView = new ErrorOutputView();
	LottoBonusNumberWithCharChecker lottoBonusNumberWithCharChecker = new LottoBonusNumberWithCharChecker();
	LottoBonusNumberRangeChecker lottoBonusNumberRangeChecker = new LottoBonusNumberRangeChecker();
	LottoBonusNumberDuplicationChecker lottoBonusNumberDuplicationChecker = new LottoBonusNumberDuplicationChecker();
	public void checkValidationOfLottoBonusNumber(Lotto lotto, String scannedLottoBonusNumberString) {
		checkLottoBonusNumberWithChar(lotto, scannedLottoBonusNumberString);
	}

	private void checkLottoBonusNumberWithChar(Lotto lotto, String scannedLottoBonusNumberString) {
		try{
			lottoBonusNumberWithCharChecker.checkLottoBonusNumberWithChar(scannedLottoBonusNumberString);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoBonusNumberWithChar();
			throw illegalArgumentException;
		}
		checkLottoBonusNumberRange(lotto, scannedLottoBonusNumberString);
	}

	private void checkLottoBonusNumberRange(Lotto lotto, String scannedLottoBonusNumberString) {
		try{
			lottoBonusNumberRangeChecker.checkLottoBonusNumberRange(scannedLottoBonusNumberString);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoBonusNumberRange();
			throw illegalArgumentException;
		}
		checkLottoBonusNumberDuplication(lotto, scannedLottoBonusNumberString);
	}

	private void checkLottoBonusNumberDuplication(Lotto lotto, String scannedLottoBonusNumberString) {
		try{
			lottoBonusNumberDuplicationChecker.checkLottoBonusNumberDuplication(lotto, scannedLottoBonusNumberString);
		}
		catch(IllegalArgumentException illegalArgumentException){
			errorOutputView.printErrorOfLottoBonusNumberDuplication();
			throw illegalArgumentException;
		}
	}

}
