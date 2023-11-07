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

	public void createLotto(int numbers) {
		lottos = new Lottos(createLottos(numbers));
	}

	public void printLottos(int number) {
		OutputView.printLottos(number, lottos.getLotts());
		System.out.println();
	}

	public void setUpWinningAndBonusLotto() {
		WinningNumbers winningNumbers = setUpWinningLotto();
		System.out.println();
		Bonus bonus = setUpBonusLotto();
		winningLotto = new WinningLotto(winningNumbers, bonus);
	}

	public void calculateWinningLotto() {
		winningLotto.calculateWinningLotto(lottos.getLotts());
	}

	private List<Lotto> createLottos(int numbers) {
		try {
			return Stream.generate(Lotto::createLotto)
				.limit(numbers)
				.collect(Collectors.toList());
		} catch(LottoException e) {
			System.out.println(e.getMessage());
			createLotto(numbers);
		}
		return null;
	}

	private WinningNumbers setUpWinningLotto() {
		try {
			InputView.askWinningNumbers();
			return new WinningNumbers(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setUpWinningLotto();
		}
	}

	private Bonus setUpBonusLotto() {
		try {
			InputView.askBonusNumber();
			return new Bonus(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return setUpBonusLotto();
		}
	}
}
