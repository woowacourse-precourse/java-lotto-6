package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String getPurchaseAmount() {
		String input = Console.readLine();
		return input;
	}
	
	public String getWinningNumbers() {
		String input = Console.readLine();
		return input;
	}
	
	public int getBonusNumber() {
		int input = Integer.parseInt(Console.readLine());
		return input;
	}
	
}
