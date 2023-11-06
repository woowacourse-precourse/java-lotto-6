package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
	
	public String buy() {
		System.out.println(MONEY_INPUT_MESSAGE);
		return Console.readLine();
	}
	
	public String winningNumber() {
		System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
		return Console.readLine();
	}
	
	public String bonusNumber() {
		System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
		return Console.readLine();
	}
}
