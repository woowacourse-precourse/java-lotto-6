package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNum {

	public static List<WinningRank> lotto(List<List<Integer>> lottos, String mynumber, String bonusnum) {

		List<WinningRank> rankingList = new ArrayList<>();
		String[] usernums = mynumber.split(",");
		int bonus = Integer.parseInt(bonusnum);

		for (int i = 0; i < lottos.size(); i++) {
			List<Integer> lotto = lottos.get(i);
			int matching = checkMatchingNumbers(lotto, usernums);

			if (matching == 5 && lottos.contains(bonus)) {
				rankingList.add(WinningRank.SECOND);
			}
			WinningRank rank = WinningRank.findByMatchingNumbers(matching);
			rankingList.add(rank);
		}

		return rankingList;
	}

	private static int checkMatchingNumbers(List<Integer> lotto, String[] usernums) {

		int matching = 0;
		for (Integer mynums : lotto) {
			if (Arrays.asList(usernums).contains(mynums.toString())) {
				matching++;
			}
		}
		return matching;
	}

}
