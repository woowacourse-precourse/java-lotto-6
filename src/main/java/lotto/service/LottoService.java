package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
	private Lottos lottos;
	private LottoWinningNumbers lottoWinningNumbers;
	public void createLotto(int numbers) {
		lottos = new Lottos(createLottos(numbers));
	}

	public void printLottos(int number) {
		OutputView.printLottos(number, lottos.getLotts());
		System.out.println();
	}

	public void setWinningLotto() {
		setUpLottoWinningNumbers(getWinningNumbers(), getBonusNumber());
	}

	private List<Lotto> createLottos(int numbers) {
		while(true) {
			try {
				return Stream.generate(Lotto::createLotto)
					.limit(numbers)
					.collect(Collectors.toList());
			} catch(LottoException e) {
				System.out.println(e.getMessage());
				createLottos(numbers);
			}
		}
	}

	private String getWinningNumbers() {
		InputView.askWinningNumbers();
		return Console.readLine();
	}

	private String getBonusNumber() {
		InputView.askBonusNumber();
		return Console.readLine();
	}

	private void setUpLottoWinningNumbers(String numbers, String bonus) {
		lottoWinningNumbers = new LottoWinningNumbers(numbers, bonus);
	}
}
