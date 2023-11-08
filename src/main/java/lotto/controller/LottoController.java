package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private static final int LOTTO_SIZE = 6;
	private static List<Lotto> lottoList = new ArrayList<>();

	public void startGame() {
		int amount = Integer.parseInt(InputView.inputAmountOfMoney());
		OutputView.printLottoAmount(amount);

		setLottoList(amount);
		OutputView.printLottoNumbers(lottoList);

		List<Integer> lottoNumber = InputView.inputLottoNumber();
		int bonusNumber = InputView.inputBonusNumber();

		OutputView.printPrizeMessage();
		OutputView.printPrizeResult();

	}

	private void setLottoList(int amount) {
		for(int i = 0 ; i < LOTTO_SIZE; i ++){
			List<Integer> lotto = new ArrayList<>();
			lotto = LottoGenerator.makeLottoList();
			lottoList.add(new Lotto(lotto));
		}
	}
}
