package view;

import camp.nextstep.edu.missionutils.Console;
import enums.Input;

public class InputView {
	
	private String buyAmount;
	private String winningNumber;
	private String bonusNumber;

	public void getBuyAmount() {
		String buyAmountMessage = Input.BUY_AMOUNT.getInput();
		System.out.println(buyAmountMessage);
		this.buyAmount = Console.readLine();
	}
}
