package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.view.OutputView;

public class LottoGame {

	public static void playGame(List<Lotto> lottoNumbers, List<Integer> lottoPrizeNumber, int bonusNumber, int amount) {
		Map<Prize, Integer> prizeCount = setPrizeCount();
		long totalPrizeMoney = caculatePrizeMoney(lottoNumbers, lottoPrizeNumber, bonusNumber, prizeCount);
		OutputView.printPrizeResult(prizeCount, totalPrizeMoney, amount);
	}

	private static long caculatePrizeMoney(List<Lotto> lottoNumbers, List<Integer> lottoPrizeNumber, int bonusNumber,
	                                       Map<Prize, Integer> prizeCount) {
		long totalPrice = 0;
		for (Lotto lotto : lottoNumbers) {
			Prize prize = checkLottoPrize(lotto, lottoPrizeNumber, bonusNumber);
			prizeCount.put(prize, prizeCount.get(prize) + 1);
			totalPrice += prize.getPrizeMoney();
		}
		return totalPrice;
	}

	private static Prize checkLottoPrize(Lotto lotto, List<Integer> lottoPrizeNumber, int bonusNumber) {
		int count = 0;
		boolean bonus = false;
		for (int num : lotto.getNumbers()) {
			if(num == bonusNumber){
				bonus = true;
			}
			if(lottoPrizeNumber.contains(num)){
				count ++;
			}
		}
		return Prize.prizeNumber(count, bonus);
	}


	private static Map<Prize, Integer> setPrizeCount() {
		Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
		for (Prize prize : Prize.values()) {
			prizeCount.put(prize, 0);
		}
		return prizeCount;
	}
}
