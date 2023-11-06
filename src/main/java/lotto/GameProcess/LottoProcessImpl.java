package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import lotto.Input.InputNumber;
import lotto.Input.InputNumberImpl;
import lotto.dataObjects.Bonus;
import lotto.dataObjects.Lotto;
import lotto.dataObjects.Money;

public class LottoProcessImpl implements LottoProcess {

	private final InputNumber inputNumber;
	private Money money;
	private Lotto lotto;
	private Bonus bonus;

	public LottoProcessImpl() {
		this.inputNumber = new InputNumberImpl();
	}

	@Override
	public void playGame() {
		inputPrice();
		inputBonusNumber();
		inputWinningNumbers();
	}

	private void inputPrice() {
		try {
			int lottoPrice = inputNumber.inputPurchasePrice();
			money = new Money(lottoPrice);
		} catch (IllegalArgumentException e) {
			inputPrice();
		}
	}

	private void inputWinningNumbers() {
		try {
			List<Integer> lottoNumbers = new ArrayList<>();
			inputNumber.inputWinningNumbers(lottoNumbers);
			lotto = new Lotto(lottoNumbers);
		} catch (IllegalArgumentException e) {
			inputWinningNumbers();
		}
	}

	private void inputBonusNumber() {
		try {
			int bonusNumber = inputNumber.inputBonusNumber();
			bonus = new Bonus(bonusNumber, this.lotto);
		} catch (IllegalArgumentException e) {
			inputBonusNumber();
		}
	}
}
