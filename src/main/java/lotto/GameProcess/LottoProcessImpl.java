package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import lotto.Input.InputNumber;
import lotto.Input.InputNumberImpl;
import lotto.validator.LottoValidator;
import lotto.validator.LottoValidatorImpl;

public class LottoProcessImpl implements LottoProcess {

	private final InputNumber inputNumber;

	public LottoProcessImpl() {
		LottoValidator validator = new LottoValidatorImpl();
		this.inputNumber = new InputNumberImpl(validator);
	}

	@Override
	public void playGame() {
		int lottoPrice = inputNumber.inputPurchasePrice();
		List<Integer> lottoNumbers = new ArrayList<>();
		inputNumber.inputWinningNumbers(lottoNumbers);
	}
}
