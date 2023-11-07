package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.CheckValidateInput;

public class InputView {
	
	private final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
	
	CheckValidateInput checkValidateInput = new CheckValidateInput();
	
	public int numberOfPurchasedLotto() {
		System.out.println(MONEY_INPUT_MESSAGE);
		return checkValidateInput.money(Console.readLine());
	}
	
	public List<Integer> winningNumber() {
		System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
		return checkValidateInput.winningNumber(Console.readLine());
	}
	
	public int bonusNumber() {
		System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
		return checkValidateInput.bonusNumber(Console.readLine());
	}
}
