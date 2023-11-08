package lotto.controller;

import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.setting.Lotto;

public class Controller {
	String money;
	boolean tfCheck;
	int checkMoney;
	int countMoney;
	List<Integer> autoNum;
	List<Integer> numbers;
	String bonusNumber;
	int bonusNum;
	boolean numCheck;

	Lotto lotto;

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

		// 공백 에러 체크
		if (money == "") {
			throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
		}

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
		countMoney = checkMoney / 1000;
		System.out.println("\n" + countMoney + "개를 구매했습니다.");
		lottoNum(countMoney);
	}

	// 로또 번호 발행하기
	public void lottoNum(int countMoney) {
		countMoney = this.countMoney;

		for (int i = 0; i < countMoney; i++) {
			autoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			// 오름차순 정렬
			autoNum.sort(Comparator.naturalOrder());
			System.out.println(autoNum);
		}

		inputLucky();
	}

	// 로또 당첨 번호 입력하기
	public void inputLucky() {
		System.out.println("\n" + "당첨 번호를 입력하세요.");

		bonusNum();
	}

	// 보너스 번호 입력하기
	public void bonusNum() {
		System.out.println("\n" + "보너스 번호를 입력하세요.");
		bonusNumber = Console.readLine();

		// 공백 에러 체크
		if (bonusNumber == "") {
			throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
		}

		for (int i = 0; i < bonusNumber.length(); i++) {
			bonusCheck();
		}

		if (numCheck = true) {
			bonusNum = Integer.parseInt(bonusNumber);
		}
	}

	// 금액이 숫자인지 체크
	public boolean bonusCheck() {
		if (bonusNumber.matches(".*[0-9].*")) {
			numCheck = true;
		}

		return numCheck;
	}

}
