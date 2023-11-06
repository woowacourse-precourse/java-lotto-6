package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoMachine {

    private int lottoPurchase;
    private List<Lotto> lottos;
    private HashMap<LottoRank, Integer> lottoRanks;
    private int lottoReturn;
    private int lottoReturnRate;

    public LottoMachine(int lottoPurchase, List<Lotto> lottos, HashMap<LottoRank, Integer> lottoRanks) {
        this.lottoPurchase = lottoPurchase;
        this.lottos = lottos;
        this.lottoRanks = lottoRanks;
        this.lottoReturn = 0;
        this.lottoReturnRate = 0;
    }

}
