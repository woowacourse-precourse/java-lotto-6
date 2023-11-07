package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private final static String SEPARATOR = ",";
	private final Error error = new Error();
	List<Lotto> lottos;
	ArrayList<Integer> winningNumbers;
	public void lottoInit() {
		LottoService lottoService = new LottoService();
		NumberGenerator generator = new NumberGenerator();
		int lottoCount = lottoService.getLottoCount(lottoService.getMoney());
		Message.PURCHASE_COUNT_MESSAGE.getMessage(lottoCount);
		for (int i = Number.ZERO.getNumber(); i < lottoCount; i++) {
			lottos.add(new Lotto(generator.numberGenerator()));
		}
	}

	public void winningNumberInit() {
		Message.WINNING_NUMBER_MESSAGE.getMessage();
		String winningNumber = Console.readLine().trim();
		for (String digit : winningNumber.split(SEPARATOR)) {
			error.checkDigitWithDuplicate(winningNumbers, digit);
			winningNumbers.add(Integer.parseInt(digit));
		}
	}

	public void bonusNumberInit() {
		Message.BONUS_NUMBER_MESSAGE.getMessage();
		String bonusNumber = Console.readLine().trim();
		error.checkDigitWithDuplicate(winningNumbers, bonusNumber);
		winningNumbers.add(Integer.parseInt(bonusNumber));
	}

	public void compareLotto() {
		for (Lotto lotto : lottos) {
			int result = lotto.match(winningNumbers);
			boolean bonus = lotto.matchBonus(winningNumbers.size() - 1);
			Result.setResult(result, bonus);
		}
	}
}
