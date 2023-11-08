package lotto.Result;

import lotto.Lotto.Lotto;
import lotto.Lotto.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public static List<WinningResult> calcWinningLottoResult(WinningLotto winningLotto, List<Lotto> paidLottos){
        List<WinningResult> winningResults = new ArrayList<>();
        for(Lotto paidLotto : paidLottos){
            winningResults.add(getWinningResult(winningLotto,paidLotto));
        }
        return winningResults;
    }

    public static WinningResult getWinningResult(WinningLotto winningLotto, Lotto paidLotto){
        int numberCount = getCorrectNumberCount(winningLotto.getLotto(),paidLotto);
        boolean bonusCheck = getContainsCount(winningLotto.getBonusNumber(),paidLotto);
        return WinningResult.calcWinningResult(numberCount,bonusCheck);
    }

    public static boolean getContainsCount(int number,Lotto lotto){
        if(lotto.getNumbers().contains(number)){
            return true;
        }
        return false;
    }

    public static int getCorrectNumberCount(Lotto winningLotto, Lotto paidLotto) {
        int count = 0;
        for(int number : winningLotto.getNumbers()){
            if(getContainsCount(number,paidLotto)) count++;
        }
        return count;
    }
    public static Map<WinningResult,Integer> getWinningResultCountMap (List<WinningResult> winningResults){
        Map<WinningResult,Integer> winningResultCountMap = initializeWinningResultCountMap();
        for(WinningResult result : winningResults){
            if(winningResultCountMap.containsKey(result)){
                winningResultCountMap.put(result,winningResultCountMap.get(result)+1);
            }
        }
        return winningResultCountMap;
    }

    //맵
    public static Map<WinningResult,Integer> initializeWinningResultCountMap() {
        Map<WinningResult,Integer> winningResultCount = new HashMap<WinningResult,Integer>();
        for(WinningResult winningResult : WinningResult.values()){
            winningResultCount.put(winningResult,0);
        }
        return winningResultCount;
    }

    public static double calcProfitRate(Map<WinningResult,Integer> winningResultCountMap, int lottoBuyCount){
        long totalPrice = 0;
        for(WinningResult winningResult : WinningResult.values()){
            totalPrice += (long)winningResultCountMap.get(winningResult)*winningResult.getWinningPrice();
        }
        return (double)(totalPrice)/(double)(lottoBuyCount*1000)*100;
    }
}