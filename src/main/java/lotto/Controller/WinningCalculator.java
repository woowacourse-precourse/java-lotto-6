//WinningCalculator.java
package lotto.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.Enum.Prize;
import lotto.Lotto;
import lotto.Money;
import lotto.WinningInfo;
import lotto.WinningNumbers;

public class WinningCalculator {

	public Map<Prize, Integer> calculatePrizes(WinningInfo winningInfo, List<Lotto> lottos){
		Map<Prize, Integer> prizeMap = new LinkedHashMap<>();

		for (Prize prize : Prize.values()) {
			prizeMap.put(prize, 0);
		}

		for(Lotto lotto : lottos){
			//디미터의 법칙 위반?
			int matchCount = winningInfo.getWinningNumbers().checkMatchCounts(lotto);
			boolean isMatchBonus = winningInfo.getBonusNumber().checkIsMatch(lotto);

			Prize prize = Prize.findPrizeByMatch(matchCount, isMatchBonus);
			if(prize != null){
				prizeMap.put(prize, prizeMap.get(prize) + 1);
			}
		}
		return prizeMap;
	}

	public double calculateProfitRate(Map<Prize, Integer> prizes, Money money){
		int pay = money.getMoney();
		int totalPrize = calculateTotalPrize(prizes);
		double profitRate = ((double) totalPrize / pay) * 100;
		profitRate = Math.round(profitRate * 100) / 100.0;
		return profitRate;
	}

	private int calculateTotalPrize(Map<Prize, Integer> prizes){
		int totalPrize = 0;
		for (Map.Entry<Prize, Integer> entry : prizes.entrySet()) {
			int prize = entry.getKey().getPrize();
			int count = entry.getValue();
			totalPrize += prize * count;
		}
		return totalPrize;
	}
}
