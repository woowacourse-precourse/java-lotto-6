package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {
	private static double earningsRate;
	public Map<Integer, Integer> cnt = new HashMap<>();

	public WinningResult(double earningsRate, Map<Integer, Integer> result) {
		this.earningsRate = earningsRate;
		this.cnt = result;
	}

	public void printingResult() {
		System.out.println("\n" + Constants.RESULT_GUIDE_STR);
		System.out.println(Constants.RESULT_GUIDE_BAR);

		for (int i = 3; i <= 5; i++) {
			System.out.print(Ranking.getPrintMsg(i));
			if (cnt.containsKey(i) == false)
				cnt.put(i, 0);
			System.out.println(cnt.get(i) + Constants.RESULT_GUIDE_CNT);
		}

		if (cnt.containsKey(6) == false)
			cnt.put(6, 0);

		System.out.println(Ranking.getPrintMsg(7) + cnt.get(7) + Constants.RESULT_GUIDE_CNT);
		System.out.println(Ranking.getPrintMsg(6) + cnt.get(6) + Constants.RESULT_GUIDE_CNT);
		System.out.println(
				Constants.RESULT_TOTAL_RATE + String.format("%.1f", earningsRate) + Constants.RESULT_PERCENTAGE_STR);
	}
}