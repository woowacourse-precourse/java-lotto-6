package lotto.util;

import lotto.domain.RateOfReturn;
import lotto.domain.WinningRate;

import java.util.*;

public class WiningResultUtil {
    private List<List<Integer>> lottoNumber;
    private List<Integer> winningNumber;
    WinningRate winningRate;
    Map<String, Integer> matchCounts;

    public WiningResultUtil() {
        lottoNumber = new ArrayList<>();
        winningNumber = new ArrayList<>();
        matchCounts = new LinkedHashMap<>();
    }

    public void setWinning(List<List<Integer>> lottoNumber, List<Integer> winningNumber){
        this.lottoNumber = lottoNumber;
        this.winningNumber = winningNumber;
    }

    public Map<String, Integer> calculateMatchCount(int bonus, RateOfReturn rateOfReturn){
        matchCounts.put(WinningRate.FIFTH.getMessage(), 0);
        matchCounts.put(WinningRate.FOURTH.getMessage(), 0);
        matchCounts.put(WinningRate.THIRD.getMessage(), 0);
        matchCounts.put(WinningRate.SECOND.getMessage(), 0);
        matchCounts.put(WinningRate.FIRST.getMessage(), 0);
        matchCounts.put(WinningRate.LOSE.getMessage(),0);
        for (List<Integer> lottoNumbers : lottoNumber) {
            int matchCount = (int) lottoNumbers.stream()
                    .filter(winningNumber::contains)
                    .count();
            if (matchCount == 5 && lottoNumbers.contains(bonus)) {
                matchCount = 7;
            }
            String message = getMatchingMessage(matchCount);
            rateOfReturn.setReward(getMatchingRevenue(matchCount));
            matchCounts.put(message, matchCounts.getOrDefault(message, 0) + 1);
        }
        return matchCounts;
    }

    private void initMatchCounts() {

    }


    private String getMatchingMessage(int matchCount) {
        if (matchCount == 3)
            return WinningRate.FIFTH.getMessage();
        if (matchCount == 4)
            return WinningRate.FOURTH.getMessage();
        if (matchCount == 5)
            return WinningRate.THIRD.getMessage();
        if (matchCount == 7)
            return WinningRate.SECOND.getMessage();
        if (matchCount == 6)
            return WinningRate.FIRST.getMessage();
        if(matchCount < 3)
            return WinningRate.LOSE.getMessage();
        return null;
    }

    private long getMatchingRevenue(int matchCount) {
        if (matchCount == 3)
            return WinningRate.FIFTH.getRateOfReturn();
        if (matchCount == 4)
            return WinningRate.FOURTH.getRateOfReturn();
        if (matchCount == 5)
            return WinningRate.THIRD.getRateOfReturn();
        if (matchCount == 7)
            return WinningRate.SECOND.getRateOfReturn();
        if (matchCount == 6)
            return WinningRate.FIRST.getRateOfReturn();
        if(matchCount < 3)
            return WinningRate.LOSE.getRateOfReturn();
        return 0;
    }



}
