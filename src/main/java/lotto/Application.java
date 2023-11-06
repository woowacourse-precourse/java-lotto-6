package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static Integer money;

	public static void main(String[] args) {
		setMoney();
		
	}

	private static void setMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			money = readNumber();

			if (money % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	private static Integer readNumber() {
		Integer number = null;
		try {
			number = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다!");
		}
		return number;
	}
}
