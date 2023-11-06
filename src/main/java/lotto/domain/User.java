package lotto.domain;

import lotto.application.IOService;

import java.util.HashMap;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoCnt;
    private long totalPrize;
    private HashMap<Rank, Integer> cntRank;

    public User() {
        this.cntRank = new HashMap<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getLottoCnt() {
        return lottoCnt;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setLottoCnt(int lottoCnt) {
        this.lottoCnt = lottoCnt;
    }

    public void setTotalPrize(long rankMoney) {
        this.totalPrize = rankMoney;
    }

    public void addCntrank(Rank rank){
        if(!cntRank.containsKey(rank)){
            cntRank.put(rank, 1);
            return;
        }

        Integer beforeCnt = cntRank.get(rank);
        cntRank.put(rank, beforeCnt + 1);
    }
}
