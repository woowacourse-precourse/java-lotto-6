package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoMachine {
    private int lottoCount;
    private List<Lotto> lottos;
    private HashMap<LottoRank, Integer> lottoRanks;
    private int lottoReturn;
    private int lottoReturnRate;

    public LottoMachine(int lottoCount, List<Lotto> lottos, HashMap<LottoRank, Integer> lottoRanks) {
        this.lottoCount = lottoCount;
        this.lottos = lottos;
        this.lottoRanks = lottoRanks;
        this.lottoReturn = 0;
        this.lottoReturnRate = 0;
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

}
