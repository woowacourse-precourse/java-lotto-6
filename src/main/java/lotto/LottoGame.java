package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
	static final int MONEY_UNIT = 1000;

	public void start() {
		int money = readMoney();
	}

	public int validateMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = Integer.parseInt(Console.readLine());

		if (money % MONEY_UNIT != 0) {
			throw new IllegalArgumentException();
		}
		return money;
	}

	public int readMoney() {
		int money;
		while (true) {
			try {
				money = validateMoney();
				break;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 유효한 정수를 입력하세요.");
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 1000원 단위가 아닙니다.");
			}
		}
		return money / MONEY_UNIT;
	}
}

