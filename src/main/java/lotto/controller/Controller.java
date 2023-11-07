package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputAmount;
import lotto.domain.InputMoney;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import lotto.domain.MoneyValidator;
import lotto.exception.LottoException;
import lotto.exception.MoneyException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
	private MoneyValidator moneyValidator;
	private InputMoney inputMoney;
	private InputAmount inputAmount;
	private Lottos lottos;
	private LottoWinningNumbers lottoWinningNumbers;

	public Controller() {
		this.moneyValidator = new MoneyValidator();
	}

	public void run() {
		setUpInputAmount(getUserInputAmount());
		setUpLottos(inputAmount.getInputAmount());
		System.out.println();
		OutputView.printLottos(inputAmount.getInputAmount(), lottos.getLotts());
		System.out.println();
		setUpLottoWinningNumbers(getWinningNumbers());
	}

	private String getUserInputAmount() {
		InputView.askInputAmount();
		return Console.readLine();
	}

	private void setUpInputAmount(String input) {
		while (true) {
			try {
				inputMoney = new InputMoney(moneyValidator, input);
				inputAmount = new InputAmount(inputMoney.getInputMoney());
				break;
			} catch(MoneyException e) {
				System.out.println(e.getMessage());
				getUserInputAmount();
			}
		}
	}

	private void setUpLottos(int numbers) {
		lottos = new Lottos(createLottos(numbers));
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

	private void setUpLottoWinningNumbers(String input) {
		lottoWinningNumbers = new LottoWinningNumbers(input);
	}
}
