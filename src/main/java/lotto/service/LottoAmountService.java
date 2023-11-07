package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.InputAmount;
import lotto.domain.InputMoney;
import lotto.view.InputView;

public class LottoAmountService {
	private InputMoney inputMoney;
	private InputAmount inputAmount;

	public void setLottoAmount() {
		setUpInputAmount(getUserInputAmount());
		System.out.println();
	}

	public int getLottoAmount() {
		return inputAmount.getInputAmount();
	}

	public int getInputMoney() {
		return inputMoney.getInputMoney();
	}

	private String getUserInputAmount() {
		InputView.askInputAmount();
		return Console.readLine();
	}

	private void setUpInputAmount(String input) {
		try {
			inputMoney = new InputMoney(input);
			inputAmount = new InputAmount(inputMoney.getInputMoney());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setLottoAmount();
		}
	}
}
