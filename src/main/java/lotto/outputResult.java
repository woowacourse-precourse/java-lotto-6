package lotto;

import java.util.List;

public class outputResult {

	private static final String printLottoPurchaseAmount = "개를 구매했습니다.";

	public static int calculateNumberOfLottoTickets(int userPurchaseAmount){
		int numberOfLottoTickets = userPurchaseAmount / 1000;
		return numberOfLottoTickets;
	}

	public static List<List<Integer>> displayLottoPurchaseResult(int purchasableLottoTickets){
		System.out.println(purchasableLottoTickets+printLottoPurchaseAmount);
		List<List<Integer>> lottoNumberLists = lottoNumGeneration.generateLottoNumberLists(purchasableLottoTickets);
		for (List<Integer> lottoNumberList : lottoNumberLists){
			System.out.println(lottoNumberList);
		}
		return lottoNumberLists;
	}

}
