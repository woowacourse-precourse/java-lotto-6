package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {
	public int getMoney() { // 사용자의 금액 입력을 받는 메서드
		while (true) {
			try {
				System.out.println("구입 금액을 입력해주세요.");
				int userInput = Integer.parseInt(readLine().trim());
				this.validateMoney(userInput);
				return userInput;
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 금액은 숫자만 입력이 가능합니다.");
			} catch (IllegalArgumentException e) {
				System.err.println("[ERROR] 금액은 천원으로 나누어 떨어져야합니다.");
			}
		}
	}

	private void validateMoney(int input) { // 사용자가 입력한 값이 1000으로 나누어 떨어지는지 예외처리
		if (input % 1000 != 0) {
			throw new IllegalArgumentException();
		}
	}

//	public int printBuyLotto() {
//		System.out.printf("%n%s개를 구매하셨습니다. %n", count);
//		return count;
//	}
}