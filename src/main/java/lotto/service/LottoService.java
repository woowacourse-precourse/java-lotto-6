package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
	private Lottos lottos;
	private WinningLotto winningLotto;

	public void createLotto(int amount) {
		lottos = new Lottos(createLottos(amount));
	}

	public void printLottos(int amount) {
		OutputView.printLottos(amount, lottos.getLotts());
		System.out.println();
	}

	public void setUpWinningLotto() {
		WinningNumbers winningNumbers = setUpWinningNumbers();
		System.out.println();
		Bonus bonus = setUpBonus();
		winningLotto = new WinningLotto(winningNumbers, bonus);
	}

	public void calculateResult() {
		winningLotto.calculateResult(lottos.getLotts());
	}

	private List<Lotto> createLottos(int amount) {
		try {
			return Stream.generate(Lotto::createLotto)
				.limit(amount)
				.collect(Collectors.toList());
		} catch(LottoException e) {
			System.out.println(e.getMessage());
			return createLottos(amount);
		}
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
