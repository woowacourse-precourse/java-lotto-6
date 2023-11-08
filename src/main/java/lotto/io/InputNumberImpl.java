package lotto.io;

import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.CommonValidator;
import lotto.utils.CommonValidatorImpl;

public class InputNumberImpl implements InputNumber {

	private final CommonValidator validator;

	public InputNumberImpl() {
		this.validator = new CommonValidatorImpl();
	}

	@Override
	public int inputPurchasePrice() {
		String price = Console.readLine();
		return validator.validatePrice(price);
	}

	@Override
	public void inputWinningNumbers(List<Integer> lottoNumbers) {
		StringTokenizer numberSplitter = new StringTokenizer(Console.readLine(), ",");
		validator.validateWinningNumber(numberSplitter, lottoNumbers);
	}

	@Override
	public int inputBonusNumber() {
		String bonusNumber = Console.readLine();
		return validator.validateBonusNumber(bonusNumber);
	}

}
