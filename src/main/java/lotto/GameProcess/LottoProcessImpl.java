package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import lotto.Input.InputNumber;
import lotto.Input.InputNumberImpl;
import lotto.dataObjects.Lotto;
import lotto.utils.LottoValidator;
import lotto.utils.LottoValidatorImpl;

public class ProcessImpl implements Process {

	private final InputNumber inputNumber;

	public ProcessImpl() {
		LottoValidator validator = new LottoValidatorImpl();
		this.inputNumber = new InputNumberImpl(validator);
	}

	@Override
	public void playGame() {
		int lottoPrice = inputNumber.inputPurchasePrice();
		List<Integer> lottoNumbers = new ArrayList<>();
		inputNumber.inputWinningNumbers(lottoNumbers);
		Lotto winningLottoNumbers = new Lotto(lottoNumbers);
	}
}
