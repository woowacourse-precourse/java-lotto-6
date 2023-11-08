package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private final Error error = new Error();
	List<Lotto> lottos = new ArrayList<>();
	List<Integer> winningNumbers = new ArrayList<>();
	LottoService lottoService = new LottoService();

	public void play() {
		lottoInit();
		winningNumberInit();
		bonusNumberInit();
		lottoService.compareLotto(lottos, winningNumbers);
		Result.printResult();
	}

	public void lottoInit() {
		int lottoCount = lottoService.getLottoCount(lottoService.getMoney());
		NumberGenerator generator = new NumberGenerator();
		String message = "\n" + lottoCount + Message.PURCHASE_COUNT_MESSAGE.getMessage();
		Message.printStringMessage(message);
		for (int i = Number.ZERO.getNumber(); i < lottoCount; i++) {
			lottos.add(new Lotto(generator.numberGenerator()));
		}
		for (Lotto lotto : lottos) {
			lotto.lottoSort();
			lotto.printLotto();
		}
	}

	private void winningNumberInit() {
		Message.WINNING_NUMBER_MESSAGE.printMessage();
		winningNumbers = lottoService.getWinningNumbers();
	}

	private void bonusNumberInit() {
		Message.BONUS_NUMBER_MESSAGE.printMessage();
		winningNumbers.add(lottoService.getBonusNumber(winningNumbers));
	}
}
