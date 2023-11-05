package lotto.Input;

import java.util.StringTokenizer;

import javax.xml.validation.Validator;

import camp.nextstep.edu.missionutils.Console;
import lotto.enumContainer.CommonString;
import lotto.validator.LottoValidator;

public class InputNumberImpl implements InputNumber {

	private final LottoValidator validator;
	private StringTokenizer numberSplitter;

	public InputNumberImpl(LottoValidator validator) {
		this.validator = validator;
	}

	@Override
	public int inputPurchasePrice() {
		String price = Console.readLine();
		validator.validateIsDigit(price);
		return Integer.parseInt(price);
	}
}
