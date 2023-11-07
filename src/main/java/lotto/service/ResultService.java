package lotto.service;

import lotto.model.LottoPurchase;
import lotto.util.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.Constants.LottoResult;

public class ResultService {
    private Map<Integer,Integer> winningResult = new HashMap<>();
    private long winningMoney;

    public ResultService() {
        init();
    }

    private void init(){
        winningResult.put(LottoResult.TREE.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(LottoResult.FOUR.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(LottoResult.FIVE.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(LottoResult.FIVE_AND_BONUS.getCount(), Constants.INITIAL_VALUE);
        winningResult.put(LottoResult.SIX.getCount(), Constants.INITIAL_VALUE);
    }
    public Map<Integer,Integer> containsNumber(final List<Integer> winningNumber, final List<LottoPurchase> userLotteries, final int bonusNumber){
        for (LottoPurchase userLottery : userLotteries) {
            int coincideCount = Constants.INITIAL_VALUE;
            for (Integer userNumber : userLottery.getUserLottery()) {
                coincideCount = addCoincideCount(winningNumber,userNumber,coincideCount);
            }
            if(coincideCount == LottoResult.FIVE.getCount())
                coincideCount = containsBonusNumber(winningNumber,bonusNumber,coincideCount);
            winningResult.put(coincideCount,winningResult.getOrDefault(coincideCount,0)+1);
        }
        return winningResult;
    }
    private int addCoincideCount(final List<Integer> winningNumber, final int userNumber, int coincideCount) {
        if(winningNumber.contains(userNumber))
            coincideCount++;
        return coincideCount;
    }
    private int containsBonusNumber(final List<Integer> winningNumber, final int bonusNumber,int coincideCount){
        if(winningNumber.contains(bonusNumber))
            coincideCount = LottoResult.FIVE_AND_BONUS.getCount();
        return coincideCount;
    }
    public long calculateWinningMoney(final Map<Integer,Integer> winningResult) {
        winningMoney += (long) winningResult.get(LottoResult.TREE.getCount()) * LottoResult.TREE.getMoney();
        winningMoney += (long) winningResult.get(LottoResult.FOUR.getCount()) * LottoResult.FOUR.getMoney();
        winningMoney += (long) winningResult.get(LottoResult.FIVE.getCount()) * LottoResult.FIVE.getMoney();
        winningMoney += (long) winningResult.get(LottoResult.FIVE_AND_BONUS.getCount()) * LottoResult.FIVE_AND_BONUS.getMoney();
        winningMoney += (long) winningResult.get(LottoResult.SIX.getCount()) * LottoResult.SIX.getMoney();
        return winningMoney;
    }
    public Double statistics(final long winningMoney, final int purchaseCount) {
        return ((double)winningMoney / (purchaseCount * Constants.DIVISION_VALUE)) * Constants.PERCENTAGE;
    }
}