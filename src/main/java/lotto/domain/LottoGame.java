package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	static final int LOTTO_PRICE = 1000;

	private static List<Lotto> generateLottoTickets(int purchaseAmount) {
		int numberOfLotto = purchaseAmount / LOTTO_PRICE;
		List<Lotto> lottos = new ArrayList<>();
		System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
		for (int i = 0; i < numberOfLotto; i++) {
			Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumber());
			lottos.add(lotto);
			lotto.printNumbers();
		}
		return lottos;
	}

	private static int getBonusNumber(List<Integer> winningNumber) {
		int bonusNumber;
		System.out.println("보너스 번호를 입력해 주세요.");
		while (true) {
			try {
				bonusNumber = UserInputManager.inputBonusNumber(winningNumber);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		return bonusNumber;
	}

	private static List<Integer> getWinningNumber() {
		List<Integer> winningNumber;
		System.out.println("당첨 번호를 입력해 주세요.");
		while (true) {
			try {
				winningNumber = UserInputManager.inputWinningNumber();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		return winningNumber;
	}

	private static int getPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		int purchaseAmount;
		while (true) {
			try {
				purchaseAmount = UserInputManager.inputPurchaseAmount();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		return purchaseAmount;
	}

	public void runLottoGame() {
		int purchaseAmount = getPurchaseAmount();
		List<Lotto> lottos = generateLottoTickets(purchaseAmount);
		List<Integer> winningNumber = getWinningNumber();
		int bonusNumber = getBonusNumber(winningNumber);

		LottoResultCalculator.printWinningDetails(lottos, winningNumber, bonusNumber);
	}
}
