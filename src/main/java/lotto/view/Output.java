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
		matchingNormal(Rank.FIFTH, result);
		matchingNormal(Rank.FOURTH, result);
		matchingNormal(Rank.THIRD, result);
		matchingBonus(Rank.SECOND, result);
		matchingNormal(Rank.FIRST, result);
		System.out.println("총 수익률은 " + result.getRateOfReturn() + "%입니다.");
	}

	private static void matchingNormal(Rank rank, Result result) {
		System.out.println(
			rank.getMatchNormalCount() + "개 일치 (" + rank.getRewardString() + "원) - " + result.getCount(
				rank)
				+ "개");
	}

	private static void matchingBonus(Rank rank, Result result) {
		System.out.println(
			rank.getMatchNormalCount() + "개 일치, 보너스 볼 일치 (" + rank.getRewardString() + "원) - "
				+ result.getCount(
				rank) + "개");
	}

	public static void newLine() {
		System.out.println();
	}

	public static void exception(Exception e) {
		System.out.println(ERROR_TITLE + e.getMessage());
	}
}
