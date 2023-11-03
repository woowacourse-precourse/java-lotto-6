package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
	static int count;

	public BuyLotto() {
		this.getMoney();
	}

	public void getMoney() { // 사용자의 금액 입력을 받는 메서드
		System.out.println("구입 금액을 입력해주세요.");
		String userInput = readLine().trim();
		this.isValidInput(userInput);

	}

	public void isValidInput(String input) { // 사용자가 입력한 값이 숫자가 맞는지 예외처리
		int userInput;
		try {
			userInput = Integer.parseInt(input);
			this.isValidMoney(userInput);
		} catch (NumberFormatException e) {
			System.err.println("[ERROR] 금액은 숫자만 입력이 가능합니다.");
			this.getMoney();
		} catch (IllegalArgumentException e) {
			this.getMoney();
		}
	}

	private void isValidMoney(int input) { // 사용자가 입력한 값이 1000으로 나누어 떨어지는지 예외처리
		if (input % 1000 != 0) {
			System.err.println("[ERROR] 금액은 천원으로 나누어 떨어져야합니다.");
			throw new IllegalArgumentException();
		}
		this.setCount(input);
	}

	private void setCount(int input) {
		count = input / 1000;
	}

	public int getCount() {
		System.out.printf("%n%s개를 구매하셨습니다. %n", count);
		return count;
	}
}