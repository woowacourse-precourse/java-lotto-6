package lotto.view;

public class ErrorOutputView {

	public void printErrorOfLottoPurchaseMoneyWithChar() {
		System.out.println("[ERROR] 로또 금액은 숫자로만 이루어져 있어야 합니다.");
	}

	public void printErrorOfLottoPurchaseMoneyUnit() {
		System.out.println("[ERROR] 로또 금액은 1000원 단위로만 입력해야 합니다.");
	}
}
