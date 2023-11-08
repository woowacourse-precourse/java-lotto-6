package lotto.domain.dto;

import lotto.WinningRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoWinResult {
    private int purchasePrice;
    private int winningAmount;
    private Map<WinningRank, Integer> winningRankCount;

    public LottoWinResult(int purchasePrice, Map<WinningRank, Integer> winningRankCount){
        this.purchasePrice = purchasePrice;
        winningAmount = 0;
        this.winningRankCount = winningRankCount;
        calculateReward();
    }

    public Map<WinningRank, Integer> getWinningRankCount() {
        return Collections.unmodifiableMap(winningRankCount);
    }

    public double rateOfReturn(){
        return ((double) winningAmount / purchasePrice) * 100;
    }

    private void calculateReward(){
        winningRankCount.forEach((winningRank, count) -> {
            winningAmount += (winningRank.getReward() * count);
        });
    }



}
