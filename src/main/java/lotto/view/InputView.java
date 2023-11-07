package lotto.view;

import static lotto.exception.ErrorMessage.*;
import static lotto.view.constant.InputConstant.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public void printPriceRequest() {
		System.out.println(PRICE_REQUEST.getValue());
	}

	public void printWinningRequest() {
		System.out.println(WINNING_REQUEST.getValue());
	}

	public String getInput() {
		String input = Console.readLine();
		if (input.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
		}
		return input;
	}
}
