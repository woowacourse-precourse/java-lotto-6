package lotto.controller.validation.bonus;

public class LottoBonusNumberWithCharChecker {

	public void checkLottoBonusNumberWithChar(String scannedLottoBonusNumberString) {
		try {
			Integer.parseInt(scannedLottoBonusNumberString);
		} catch (Exception exception) {
			throw new IllegalArgumentException();
		}
	}
}
