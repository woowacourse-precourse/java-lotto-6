package lotto;

import java.util.List;

class LottoPrint {
	protected static void printPurchase() {
		System.out.println("구입금액을 입력해 주세요.");
	}
	
	protected static void printLottos(List<List<Integer>> randomNumbers, int lottoTrials) {
		System.out.println("\n" + lottoTrials + "개를 구매했습니다.");
		for (int i = 0; i < lottoTrials; i++) {
			System.out.print("[");
			for (int j = 0; j < 5; j++) {
				System.out.print(randomNumbers.get(i).get(j) + ", ");
			}
			System.out.println(randomNumbers.get(i).get(5) + "]");
		}
	}
	
	protected static void printWinningNumbers() {
		System.out.println("\n당첨 번호를 입력해 주세요.");
	}
	
	protected static void printBonusNumber() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
	}
	
	protected static void printResult(List<Integer> rankCount, double ratio) {
		System.out.println("\n당첨 통계");
		System.out.println("---");
		System.out.println(Rank.FIRST.message() + " - " + rankCount.get(1) + "개");
		System.out.println(Rank.SECOND.message() + " - " + rankCount.get(2) + "개");
		System.out.println(Rank.THIRD.message() + " - " + rankCount.get(3) + "개");
		System.out.println(Rank.FOURTH.message() + " - " + rankCount.get(4) + "개");
		System.out.println(Rank.FIFTH.message() + " - " + rankCount.get(5) + "개");
		System.out.println("총 수익률은 " + ratio + "%입니다.");
	}
}
