package lotto.Input;

import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validator.LottoValidator;

public class InputNumberImpl implements InputNumber {

	private final LottoValidator validator;
	private StringTokenizer numberSplitter;

	public InputNumberImpl(LottoValidator validator) {
		this.validator = validator;
	}

	@Override
	public void inputPurchasePrice() {
		String price = Console.readLine();
		validator.validatePrice(price);
	}

	@Override
	public void inputWinningNumbers(Lotto lotto) {
		numberSplitter = new StringTokenizer(Console.readLine(), ",");
		validator.validateWinningNumber(numberSplitter, lotto);
	}

	@Override
	public void inputBonusNumber() {
		String bonusNumber = Console.readLine();
		validator.validateBonusNumber(bonusNumber);
	}



}
