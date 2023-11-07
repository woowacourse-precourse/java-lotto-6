package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Result;

public class Output {

	public static final String ERROR_TITLE = "[ERROR] ";

	public static void purchaseLottoNumbers(List<Lotto> purchasedLottoList) {
		System.out.println(purchasedLottoList.size() + "개를 구매했습니다.");
		purchasedLottoList
			.forEach(lotto -> System.out.println(lotto.toString()));
	}

	public static void winningResult(Result result) {
		System.out.println("당첨 통계\n"
			+ "---");
		System.out.println(
			Rank.FIFTH.getMatchNormalCount() + "개 일치 (" + Rank.FIFTH.getRewardString() + "원) - " + result.getCount(Rank.FIFTH)
				+ "개");
		System.out.println(
			Rank.FOURTH.getMatchNormalCount() + "개 일치 (" + Rank.FOURTH.getRewardString() + "원) - " + result.getCount(
				Rank.FOURTH) + "개");
		System.out.println(
			Rank.THIRD.getMatchNormalCount() + "개 일치 (" + Rank.THIRD.getRewardString() + "원) - " + result.getCount(Rank.THIRD)
				+ "개");
		System.out.println(
			Rank.SECOND.getMatchNormalCount() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND.getRewardString() + "원) - " + result.getCount(
				Rank.SECOND) + "개");
		System.out.println(
			Rank.FIRST.getMatchNormalCount() + "개 일치 (" + Rank.FIRST.getRewardString() + "원) - " + result.getCount(Rank.FIRST)
				+ "개");
		System.out.println("총 수익률은 " + result.getRateOfReturn() + "%입니다.");
	}

	public static void newLine() {
		System.out.println();
	}

	public static void exception(Exception e) {
		System.out.println(ERROR_TITLE + e.getMessage());
	}
}
