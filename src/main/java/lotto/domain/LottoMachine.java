package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    private int lottoPurchase;
    private int lottoCount;
    private List<Lotto> lottos;
    private List<Integer> lottoWinningNumbers;
    private int lottoBonusNumber;
    private HashMap<LottoRank, Integer> lottoRanks;
    private String lottoReturnRate;

    public LottoMachine(int lottoPurchase, int lottoCount, List<Lotto> lottos, HashMap<LottoRank, Integer> lottoRanks) {
        this.lottoPurchase = lottoPurchase;
        this.lottoCount = lottoCount;
        this.lottos = lottos;
        this.lottoRanks = lottoRanks;
        this.lottoReturnRate = "";
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public void updateLottoWinningNumbers(int lottoWinningNumber){
        this.lottoWinningNumbers.add(lottoWinningNumber);
    }

    public void updateLottoBonusNumber(int lottoBonusNumber){
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public void updateLottoRanks(LottoRank lottoRank){
        if (lottoRanks.containsKey(lottoRank)){
            lottoRanks.put(lottoRank, lottoRanks.get(lottoRank)+1);
        } else if (!lottoRanks.containsKey(lottoRank)){
            lottoRanks.put(lottoRank, 1);
        }
    }

    public List<Integer> getLottoWinningNumbers(){
        return this.lottoWinningNumbers;
    }

    public int getLottoBonusNumber(){
        return this.lottoBonusNumber;
    }

    public HashMap<LottoRank, Integer> getLottoRanks(){
        return this.lottoRanks;
    }

    public void returnLottoReturnRate(String lottoReturnRate){
        this.lottoReturnRate = lottoReturnRate;
    }

    public int getLottoPurchase(){
        return this.lottoPurchase;
    }

}
