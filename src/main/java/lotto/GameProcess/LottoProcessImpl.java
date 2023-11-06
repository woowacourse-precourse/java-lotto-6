package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import lotto.Input.InputNumber;
import lotto.Input.InputNumberImpl;
import lotto.dataObjects.Bonus;
import lotto.dataObjects.Lotto;
import lotto.dataObjects.Money;
import lotto.utils.LottoValidator;
import lotto.utils.LottoValidatorImpl;

public class LottoProcessImpl implements LottoProcess {

	private final InputNumber inputNumber;

	public LottoProcessImpl() {
		LottoValidator validator = new LottoValidatorImpl();
		this.inputNumber = new InputNumberImpl(validator);
	}

	@Override
	public void playGame() {
		int lottoPrice = inputNumber.inputPurchasePrice();
		Money money = new Money(lottoPrice);

		List<Integer> lottoNumbers = new ArrayList<>();
		inputNumber.inputWinningNumbers(lottoNumbers);
		Lotto winningLottoNumbers = new Lotto(lottoNumbers);

		int bonusNumber = inputNumber.inputBonusNumber();
		Bonus bonus = new Bonus(bonusNumber);
	}
}
