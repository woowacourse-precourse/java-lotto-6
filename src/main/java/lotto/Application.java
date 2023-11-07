package lotto;

import static lotto.MyLottos.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {
		System.out.println("구입금액을 입력해 주세요");
		InputMoney inputMoney = getValidInputMoney();

		int purchaseCount = inputMoney.getMoney() / LOTTO_PRICE;
		String info = String.format("%d개를 구매했습니다.", purchaseCount);
		System.out.println(info);

		MyLottos myLottos = new MyLottos(purchaseCount);
		myLottos.printPurchaseLotto();

		System.out.println("당첨 번호를 입력해 주세요");
		Lotto winNumbers = getValidWinnerLotto();
		System.out.println("보너스 번호를 입력해 주세요");
		BonusNumber bonusNumber = getValidBonusNumber(winNumbers);

		System.out.println("당첨 통계");
		System.out.println("---");
		myLottos.compareLottoNumber(winNumbers, bonusNumber);
		myLottos.printResults();
		myLottos.calculateEarningRate();
		myLottos.printProfit();
	}

	private static InputMoney getValidInputMoney() {
		while (true) {
			try {
				int userInput = UserInputValidator.validateInputNumber(Console.readLine());
				return new InputMoney(userInput);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static Lotto getValidWinnerLotto() {
		while (true) {
			try {
				List<Integer> numbers = UserInputValidator.validateInputNumbers(Console.readLine());
				return new Lotto(numbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static BonusNumber getValidBonusNumber(Lotto winNumbers) {
		while (true) {
			try {
				int inputNumber = UserInputValidator.validateInputNumber(Console.readLine());
				return new BonusNumber(inputNumber, winNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
