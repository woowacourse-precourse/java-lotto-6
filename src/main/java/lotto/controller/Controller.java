package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputAmount;
import lotto.domain.InputMoney;
import lotto.domain.MoneyValidator;
import lotto.exception.MoneyException;
import lotto.view.InputView;

public class Controller {
	private MoneyValidator moneyValidator;
	private InputMoney inputMoney;
	private InputAmount inputAmount;

	public Controller() {
		this.moneyValidator = new MoneyValidator();
	}

	public void run() {
		setUpInputAmount(getUserInputAmount());
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
}
