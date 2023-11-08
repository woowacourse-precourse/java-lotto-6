package view;

import camp.nextstep.edu.missionutils.Console;
import enums.Input;

public class InputView {
	
	public static String getBuyAmount() {
		System.out.println(Input.BUY_AMOUNT.getInput());
		return Console.readLine();
	}
	
	public static String getNumberListText() {
		System.out.println();
		System.out.println(Input.WINNING_NUMBER.getInput());
		return Console.readLine();
	}

	public static String getBonusNumberText() {
		System.out.println();
		System.out.println(Input.BONUS_NUMBER.getInput());
		return Console.readLine();
	}
}
