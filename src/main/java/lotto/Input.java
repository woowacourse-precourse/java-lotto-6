package lotto;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private ArrayList<Lotto> lotto = new ArrayList<>();

	public static void UserInput() {

		String usermoney = moneyInput();

		int lottocount = processNumsInput(usermoney);

		Lotto.printLotto(lottocount);

		Lotto.Create(lottocount);

		String usernums = numsInput();

		String bonusnum = bonusInput();

		checkNum(usernums, bonusnum);

	}

	private static void checkNum(String usernums, String strbonusnum) {

		int bonusnum = Integer.parseInt(strbonusnum);
		String[] numslist = usernums.split(",");

		for (int i = 0; i < numslist.length; i++) {
			int num = Integer.parseInt(numslist[i]);
		}

	}

	private static String numsInput() {

		System.out.println("당첨 번호를 입력해주세요.");

		return Console.readLine();
	}

	private static String bonusInput() {

		System.out.println("보너스 번호를 입력해 주세요.");

		return Console.readLine();
	}

	private static int processNumsInput(String strusermoney) {

		int usermoney = Integer.parseInt(strusermoney);

		int lottocount = (usermoney / 1000);

		return lottocount;

	}

	private static String moneyInput() {

		System.out.println("구입금액을 입력해 주세요.");

		return Console.readLine();
	}
}
