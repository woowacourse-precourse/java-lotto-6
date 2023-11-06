package lotto.model;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
	private static final int LOTTO_NUMBERS_COUNT = 6;
	//1000단위의 정수당 한개의 Lotto 객체 리스트
	public static List<Lotto> createObjectPerThousandUnits(int inputData){
		int playerInputThousands = inputData/1000;
		List<Lotto> lotto_list = new ArrayList<Lotto>();
		for(int i=1;i<=playerInputThousands;i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			lotto_list.add(lotto);
		}
		return lotto_list;
	}
	private static int getWinningCount(List<Integer> playerLottoNumber,List<Integer> winningNumbers) {
	    int winningCount = 0;
	    for(int i=0;i<LOTTO_NUMBERS_COUNT;i++) {
	    	if(playerLottoNumber.get(i) == winningNumbers.get(i)) winningCount++;
	    }
		return winningCount;
	}
	private static boolean isBonusNumberIncluded(List<Integer> playerLottoNumber,int bonusNumber) {
		boolean bonusMatch = false;
		for(int playerNum : playerLottoNumber) {
			if(playerNum == bonusNumber) return true;
		}
		return bonusMatch;
	}
	
	public static long getTotalWinningAmount(List<Lotto> playerLottos,List<Integer> winningNumbers,int bonusNumber) {
		boolean bonusMatch = false; int winningCount = 0; long totalWinningAmount = 0;
		for(Lotto playerLotto : playerLottos) {
			winningCount = getWinningCount(playerLotto.getNumbers(),winningNumbers);
			bonusMatch = isBonusNumberIncluded(playerLotto.getNumbers(), bonusNumber);
			totalWinningAmount += LottoPrize.valueOf(winningCount, bonusMatch).getWinnings();
		}
		return totalWinningAmount;
	}

}
