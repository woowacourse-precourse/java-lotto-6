package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoGame;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private static final int LOTTO_SIZE = 6;
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 45;

	public void startGame() {
		int amount = LottoAmount.inputAmount();
		OutputView.printLottoAmount(amount);

		List<Lotto> lottos = setLottos(amount);

		List<Integer> lottoPrizeNumber = setPrizeNumber();
		int bonusNumber = setBonusNumber();

		LottoGame.playGame(lottos, lottoPrizeNumber, bonusNumber, amount);

	}

	private int setBonusNumber() {
		int bonusNumber = InputView.inputBonusNumber();
		if (bonusNumber > MAX_NUM || bonusNumber < MIN_NUM) {
			System.out.println("[ERROR] 보너스 번호는 1에서 45사이의 수여야 합니다.");
			throw new IllegalArgumentException();
		}
		return bonusNumber;
	}

	private List<Integer> setPrizeNumber() {
		List<Integer> prizeNumber = InputView.inputLottoPrizeNumber();
		validatePrizeNumber(prizeNumber);
		return prizeNumber;
	}

	private void validatePrizeNumber(List<Integer> prizeNumber) {
		if (prizeNumber.size() != LOTTO_SIZE) {
			System.out.println("[ERROR] 당첨 번호는 6개여야 합니다.");
			throw new IllegalArgumentException();
		}
		if (prizeNumber.stream()
				.distinct()
				.count() != prizeNumber.size()) {
			System.out.println("[ERROR] 중복된 당첨 번호는 존재할 수 없습니다.");
			throw new IllegalArgumentException();
		}
		for (Integer it : prizeNumber) {
			if (it > MAX_NUM || it < MIN_NUM) {
				System.out.println("[ERROR] 당첨 번호는 1에서 45 사이의 수여야 합니다.");
				throw new IllegalArgumentException();
			}
		}

	}


	private List<Lotto> setLottos(int amount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			List<Integer> lottoNumber = LottoGenerator.makeLottoList();
			Lotto lotto = new Lotto(lottoNumber);
			lottos.add(lotto);
			OutputView.printLottoNumbers(lotto);
		}
		return lottos;
	}
}
