package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static void UserInput() {

		int matching = 0;

		String usermoney = moneyInput();

		int lottocount = processNumsInput(usermoney);

		Lotto.printLottocount(lottocount);

		List<List<Integer>> lottos = Lotto.Create(lottocount);

		Lotto.printLottoNum(lottos);

		String usernums = numsInput();
		String bonusnum = bonusInput();

		Lotto.checkNum(lottos, usernums);
		System.out.println(matching);

	}

	private static int processNumsInput(String strusermoney) {

		int usermoney = Integer.parseInt(strusermoney);

		int lottocount = (usermoney / 1000);

		return lottocount;

	}

	private static String numsInput() {
		System.out.println();
		System.out.println("당첨 번호를 입력해주세요.");

		return Console.readLine();
	}

	private static String bonusInput() {
		System.out.println();
		System.out.println("보너스 번호를 입력해 주세요.");

		return Console.readLine();
	}

	private static String moneyInput() {

		System.out.println("구입금액을 입력해 주세요.");

		return Console.readLine();
	}
}
