package lotto;

import java.util.List;

public class LottoGame {

	public static void run() {

		String usermoney = Input.moneyInput();

		int lottoCount = Input.calculateLottoCount(usermoney);

		printLottocount(lottoCount);

		List<List<Integer>> lottos = Lotto.create(lottoCount);

		printLottoNum(lottos);

		List<Integer> userNums = Input.numbers();
		
		int bonusUserNum = Input.bonus(userNums);

		List<WinningRank> rankingList = CheckNum.lotto(lottos, userNums, bonusUserNum);

		WinningRank.printResult(rankingList);

		Profit.calculate(rankingList, usermoney);

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
