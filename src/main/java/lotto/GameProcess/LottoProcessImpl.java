package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.Validator;

import lotto.Input.InputNumber;
import lotto.Input.InputNumberImpl;
import lotto.Lotto;
import lotto.validator.LottoValidator;
import lotto.validator.LottoValidatorImpl;

public class LottoProcessImpl implements LottoProcess {

	private final InputNumber inputNumber;
	private final Lotto lotto;
	public LottoProcessImpl() {
		LottoValidator validator = new LottoValidatorImpl();
		this.inputNumber = new InputNumberImpl(validator);
		List<Integer> numbers = new ArrayList<>();
		this.lotto = new Lotto(numbers);
	}

	@Override
	public void playGame() {
		inputNumber.inputPurchasePrice();
		inputNumber.inputWinningNumbers(lotto);
	}
}
