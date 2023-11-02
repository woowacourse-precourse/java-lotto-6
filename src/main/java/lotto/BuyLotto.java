package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
	static int money;

	public void getMoney() {
		System.out.println("구입 금액을 입력해주세요.");
		String userInput = readLine().trim();
		this.isValidInput(userInput);
//		System.out.println(userInput);
	}

	private void isValidInput(String input) {
		int userInput;
		try {
			userInput = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("[ERROR] 금액은 숫자만 입력이 가능합니다.");
			this.getMoney();
		}
	}
}