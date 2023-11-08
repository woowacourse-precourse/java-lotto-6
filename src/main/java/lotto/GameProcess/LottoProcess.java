package lotto.GameProcess;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dataObjects.Bonus;
import lotto.dataObjects.Lotto;
import lotto.dataObjects.Money;
import lotto.enumContainer.RelateToLotto;
import lotto.io.InputNumber;
import lotto.io.InputNumberImpl;
import lotto.io.PrintGenerator;
import lotto.io.PrintGeneratorImpl;

public class LottoProcess {

	private final InputNumber inputNumber;
	private final PrintGenerator PrintGenerator;
	private Money money;
	private Lotto lotto;
	private Bonus bonus;

	public LottoProcess() {
		this.inputNumber = new InputNumberImpl();
		this.PrintGenerator = new PrintGeneratorImpl();
	}

	public void playGame() {
		PrintGenerator.printInputMent("구입금액을");
		inputPrice();

		List<List<Integer>> IssuedLotto = generateLotto();
		PrintGenerator.printPurchaseNumbers(IssuedLotto);

		PrintGenerator.printInputMent("당첨 번호를");
		inputWinningNumbers();

		PrintGenerator.printInputMent("보너스 번호를");
		inputBonusNumber();

		lotto.checkLotto(bonus.getNumber(), IssuedLotto, money);
		PrintGenerator.printWinningStatistics();

		double profitRate = money.calculateProfitRate();
		PrintGenerator.printBenefit(profitRate);
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
			bonus = new Bonus(bonusNumber, lotto);
		} catch (IllegalArgumentException e) {
			inputBonusNumber();
		}
	}

	private List<List<Integer>> generateLotto() {
		List<List<Integer>> bundleOfLotto = new ArrayList<>();
		int perchaceCount = money.calculateAmount();
		for (int count = 0; count < perchaceCount; count++) {
			List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
					RelateToLotto.START.number(),
					RelateToLotto.END.number(),
					RelateToLotto.COUNT.number());
			bundleOfLotto.add(lottoNumbers);
		}
		return bundleOfLotto;
	}
}
