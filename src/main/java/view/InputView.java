package view;

import camp.nextstep.edu.missionutils.Console;
import enums.Input;

public class InputView {
	
	public static String getBuyAmount() {
		System.out.println(Input.BUY_AMOUNT.getInput());
		return Console.readLine();
	}
}
