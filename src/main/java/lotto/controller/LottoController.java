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
	private static List<Lotto> lottoNumbers = new ArrayList<>();

	public void startGame() {
		int amount = LottoAmount.inputAmount();
		OutputView.printLottoAmount(amount);

		setLottoList(amount);
		OutputView.printLottoNumbers(lottoNumbers);

		List<Integer> lottoPrizeNumber = InputView.inputLottoPrizeNumber();
		int bonusNumber = InputView.inputBonusNumber();

		LottoGame.playGame(lottoNumbers, lottoPrizeNumber, bonusNumber);

		OutputView.printPrizeMessage();
		OutputView.printPrizeResult();

	}


	private void setLottoList(int amount) {
		for (int i = 0; i < amount; i++) {
			List<Integer> lotto = new ArrayList<>();
			lotto = LottoGenerator.makeLottoList();
			lottoNumbers.add(new Lotto(lotto));
		}
	}
}
