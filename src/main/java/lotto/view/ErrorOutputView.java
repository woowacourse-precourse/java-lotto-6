package lotto.view;

import static lotto.model.constant.StringSymbolicConstantEnum.CHANGE_LINE;

public class ErrorOutputView {
	public void printErrorOfLottoPurchaseMoneyWithChar() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 금액은 숫자로만 이루어져 있어야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoPurchaseMoneyUnit() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 금액은 1000원 단위로만 입력해야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoNumberWithChar() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 번호는 숫자만 입력하셔야 하고, 구분은 쉼표(,)로만 하셔야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoNumberCount() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 번호는 정확히 6개만 입력하셔야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoNumberRange() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoNumberDuplication() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 로또 번호는 중복이 안되어야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoBonusNumberWithChar() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 보너스 번호는 숫자만 입력하셔야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoBonusNumberRange() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}

	public void printErrorOfLottoBonusNumberDuplication() {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println("[ERROR] 보너스 번호는 로또 번호들과 중복되지 않아야 합니다.");
		System.out.print(CHANGE_LINE.getValue());
	}
}
