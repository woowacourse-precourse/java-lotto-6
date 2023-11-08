package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNum {

	public static List<WinningRank> lotto(List<List<Integer>> lottos, List<Integer> inputNumber, int inputBonus) {

		List<WinningRank> rankingList = new ArrayList<>();

		for (int i = 0; i < lottos.size(); i++) {
			List<Integer> lotto = lottos.get(i);
			int matching = checkMatchingNumbers(lotto, inputNumber);

			if (matching == 5 && lottos.contains(inputBonus)) {
				rankingList.add(WinningRank.SECOND);
			}
			WinningRank rank = WinningRank.findByMatchingNumbers(matching);
			rankingList.add(rank);
		}

		return rankingList;
	}

	private static int checkMatchingNumbers(List<Integer> lotto, List<Integer> usernums) {
	    int matching = 0;
	    
	    for (Integer mynums : lotto) {
	        if (usernums.contains(mynums)) {
	            matching++;
	        }
	    }
	    
	    return matching;
	}

}
