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

	private String getUserInputAmount() {
		InputView.askInputAmount();
		return Console.readLine();
	}

	private void setUpInputAmount(String input) {
		while (true) {
			try {
				inputMoney = new InputMoney(input);
				inputAmount = new InputAmount(inputMoney.getInputMoney());
				break;
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
				getUserInputAmount();
			}
		}
	}
}
