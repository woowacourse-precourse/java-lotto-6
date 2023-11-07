package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

	public static void run() {

		String usermoney = moneyInput();

		int lottoCount = processNumsInput(usermoney);

		printLottocount(lottoCount);

		List<List<Integer>> lottos = Lotto.Create(lottoCount);

		printLottoNum(lottos);

		String userNums = numsInput();
		String bonusUserNum = bonusInput();

		List<WinningRank> rankingList = CheckNum.lotto(lottos, userNums, bonusUserNum);

		WinningRank.printResult(rankingList);

	}

	private static int processNumsInput(String strUserMoney) {

		int userMoney = Integer.parseInt(strUserMoney);

		int lottocount = (userMoney / 1000);

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

	private static void printLottocount(int lottoCount) {

		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");

	}

	private static void printLottoNum(List<List<Integer>> lottos) {

		for (int i = 0; i < lottos.size(); i++) {
			System.out.println(lottos.get(i));
		}
	}

}
