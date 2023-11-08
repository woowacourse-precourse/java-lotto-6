package lotto;

import java.util.List;

public class LottoGame {

	public static void run() {

		int userMoney = Input.money();

		int lottoCount = calculateLottoCount(userMoney);

		printLottocount(lottoCount);

		List<List<Integer>> lottos = Lotto.create(lottoCount);

		printLottoNumber(lottos);

		List<Integer> userNums = Input.numbers();

		int bonusUserNum = Input.bonus(userNums);

		List<WinningRank> rankings = CheckNum.lotto(lottos, userNums, bonusUserNum);

		WinningRank.printResult(rankings);

		Profit.calculate(rankings, userMoney);

	}

	private static void printLottocount(int lottoCount) {

		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");

	}

	private static void printLottoNumber(List<List<Integer>> lottos) {
		
		for (int i = 0; i < lottos.size(); i++) {
			System.out.println(lottos.get(i));
		}
		System.out.println();
	}

	public static int calculateLottoCount(int userMoney) {

		int lottoCount = (userMoney / 1000);

		return lottoCount;

	}

}
