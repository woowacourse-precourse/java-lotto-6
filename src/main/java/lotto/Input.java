package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static int calculateLottoCount(String strUserMoney) {

		int userMoney = Integer.parseInt(strUserMoney);

		int lottoCount = (userMoney / 1000);

		return lottoCount;

	}

	public static String numsInput() {

		System.out.println();
		System.out.println("당첨 번호를 입력해 주세요.");

		return Console.readLine();
	}

	public static String bonusInput() {

		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");

		return Console.readLine();
	}

	public static String moneyInput() {

		System.out.println("구입금액을 입력해 주세요.");

		return Console.readLine();
	}

}
