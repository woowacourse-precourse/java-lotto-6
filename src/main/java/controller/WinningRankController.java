package controller;

import constant.Rank;
import domain.Lotto;
import domain.WinningMachine;

import java.util.HashMap;
import java.util.List;

public class WinningRankController {
    private WinningMachine winningMachine;
    private HashMap<Rank, Integer> rankResult;

    public WinningRankController(WinningMachine winningMachine){
        this.winningMachine = winningMachine;
        rankResult = new HashMap<Rank, Integer>();
    }


    public HashMap<Rank, Integer> getRankCountResult(List<Lotto> lottos){
        initRankResult();
        for(Lotto lotto : lottos){
            Rank rank = winningMachine.getWinningRank(lotto);
            int rankCount = rankResult.getOrDefault(rank, 0);
            rankResult.put(rank, rankCount +1);
        }
        return rankResult;
    }

    private void initRankResult() {
        rankResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }
    }


}
