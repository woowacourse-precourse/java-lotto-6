package lotto.domain;

import lotto.application.IOService;

import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int lottoCnt;
    private long prizeMoney;



    public List<Lotto> getLottos() {
        return lottos;
    }
    public int getLottoCnt() {
        return lottoCnt;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setLottoCnt(int lottoCnt) {
        this.lottoCnt = lottoCnt;
    }

    public void setPrizeMoney(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }


}
