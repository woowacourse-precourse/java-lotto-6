package lotto.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int LOTTO_NUMBER_MAX = 45;

	public static List<Lotto> createObjectPerThousandUnits(int inputData){
		int playerInputThousands = inputData/LOTTO_PRICE_UNIT;
		List<Lotto> lottoList = new ArrayList<Lotto>();
		for(int i=1;i<=playerInputThousands;i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_COUNT));
			lottoList.add(lotto);
		}
		return lottoList;
	}
	private static int getWinningCount(List<Integer> playerLottoNumber,List<Integer> winningNumbers) {
		int winningCount =0;
	    for (int number : playerLottoNumber) {
	        if (winningNumbers.contains(number)) {
	            winningCount++;
	        }
	    }
	    return winningCount;
	}
    private static boolean isBonusNumberMatched(List<Integer> playerLottoNumbers, int bonusNumber) {
        return playerLottoNumbers.contains(bonusNumber);
    }
	
	public static long getTotalWinningAmount(List<Lotto> playerLottos,List<Integer> winningNumbers,int bonusNumber) {
		long totalWinningAmount = 0;
		for(Lotto playerLotto : playerLottos) {
			int winningCount = getWinningCount(playerLotto.getNumbers(),winningNumbers);
			boolean bonusMatch = isBonusNumberMatched(playerLotto.getNumbers(), bonusNumber);
			totalWinningAmount += LottoPrize.valueOf(winningCount, bonusMatch).getWinnings();
		}
		return totalWinningAmount;
	}
	public static Map<String,Integer> getTotalWinningRankCount(List<Lotto> playerLottos,List<Integer> winningNumbers,int bonusNumber) {
		Map<String,Integer> rankCount = new HashMap<>(); 
		for(Lotto playerLotto : playerLottos) {
			int winningCount = getWinningCount(playerLotto.getNumbers(), winningNumbers);
			boolean bonusMatch = isBonusNumberMatched(playerLotto.getNumbers(), bonusNumber);
			String rank = LottoPrize.valueOf(winningCount,bonusMatch).name();
			rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
		}
		return rankCount;
	}
	public static double calculateReturnOnInvestment(long totalWinningAmount,List<Lotto> playerLottos) {
		double investment = playerLottos.size() * (double) LOTTO_PRICE_UNIT;
		return (totalWinningAmount / investment) * 100;
	}
}
