package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
	String money;
	boolean tfCheck;
	int checkMoney;

	public Controller() {
	}

	public void run() {
		try {
			start();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		System.out.println("구입금액을 입력해 주세요.");
		inputMoney();
	}

	// 금액 입력
	public void inputMoney() {
		money = Console.readLine();
		for (int i = 0; i < money.length(); i++) {
			checkMoney();
		}
		if (tfCheck = true) {
			checkMoney = Integer.parseInt(money);
		}

		// 금액이 천원 단위인지 체크
		if (checkMoney % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
		}

		countMoney();
	}

	// 금액이 숫자인지 체크
	public boolean checkMoney() {
		if (money.matches(".*[0-9].*")) {
			tfCheck = true;
		}

		return tfCheck;
	}

	// 몇 장의 로또를 구매했는 지 출력
	public void countMoney() {
		System.out.println(checkMoney / 1000 + "개를 구매했습니다.");
	}

}
