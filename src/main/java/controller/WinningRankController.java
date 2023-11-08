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

    public void run(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            Rank rank = winningMachine.getWinningRank(lotto);
            addRank(rank);
        }
    }

    private void addRank(Rank rank){
        int rankCount = rankResult.getOrDefault(rank, 0);
        rankResult.replace(rank, rankCount +1);
    }


}
