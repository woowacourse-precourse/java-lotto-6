package lotto.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
	private List<Lotto> lottos;
	private WinningLotto winningLotto;

	public void createLottos(int amount) {
		try {
			lottos = Stream.generate(Lotto::createLotto)
				.limit(amount)
				.collect(Collectors.toList());
		} catch(LottoException e) {
			System.out.println(e.getMessage());
			createLottos(amount);
		}
	}

	public void printLottos(int amount) {
		OutputView.printLottos(amount, lottos);
		System.out.println();
	}

	public void setUpWinningLotto() {
		WinningNumbers winningNumbers = setUpWinningNumbers();
		System.out.println();
		Bonus bonus = setUpBonus();
		winningLotto = new WinningLotto(winningNumbers, bonus);
	}

	public Map calculateAndGetResult() {
		return winningLotto.calculateResult(lottos);
	}

	private WinningNumbers setUpWinningNumbers() {
		try {
			InputView.askWinningNumbers();
			return new WinningNumbers(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setUpWinningNumbers();
		}
	}

	private Bonus setUpBonus() {
		try {
			InputView.askBonusNumber();
			return new Bonus(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setUpBonus();
		}
	}
}
