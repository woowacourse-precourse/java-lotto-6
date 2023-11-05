package lotto.view;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class InputView {
	public String getPurchaseAmount() {
		String input = Console.readLine();
		return input;
	}
	
	public String getWinningNumbers() {
		String input = Console.readLine();
		return input;
	}
	
	public WinningNumbers getWinningNumbers() {
		String input = Console.readLine();
		List<Integer> winningNumbers = new ArrayList<>();
		for(String s : input.split(",")) {
			// 검사
			winningNumbers.add(Integer.parseInt(s));
		}
		return new WinningNumbers(winningNumbers);
	}
	
	
	public int getBonusNumber() {
		int input = Integer.parseInt(Console.readLine());
		return input;
	}
}
