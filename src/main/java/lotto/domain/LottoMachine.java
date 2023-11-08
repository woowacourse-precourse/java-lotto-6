package lotto.domain;

import lotto.common.LottoFinalConsts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoMachine implements LottoFinalConsts {

    private int lottoPurchase;
    private List<Lotto> lottos;
    private List<Integer> lottoWinningNumbers;
    private int lottoBonusNumber;
    private HashMap<LottoRank, Integer> lottoRanks;
    private String lottoReturnRate;

    public LottoMachine(int lottoPurchase, List<Lotto> lottos, HashMap<LottoRank, Integer> lottoRanks) {
        this.lottoPurchase = lottoPurchase;
        this.lottos = lottos;
        this.lottoRanks = lottoRanks;
        this.lottoReturnRate = "";
        this.lottoWinningNumbers = new ArrayList<>();
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public void updateLottoWinningNumbers(int lottoWinningNumber){
        isNumberAlreadyExist(lottoWinningNumber, lottoWinningNumbers);
        this.lottoWinningNumbers.add(lottoWinningNumber);
    }

    public void updateLottoBonusNumber(int lottoBonusNumber){
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public void updateLottoRanks(LottoRank lottoRank){
        if (lottoRanks.containsKey(lottoRank)){
            lottoRanks.put(lottoRank, lottoRanks.get(lottoRank)+ADD_COUNT_ONE);
        } else if (!lottoRanks.containsKey(lottoRank)){
            lottoRanks.put(lottoRank, ADD_COUNT_ONE);
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

    public String getLottoReturnRate(){
        return this.lottoReturnRate;
    }

    public void isNumberAlreadyExist(int winningNumber, List<Integer> lottoWinningNumbers){
        if (lottoWinningNumbers.contains(winningNumber)){
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE+LOTTO_WINNING_HAS_DUPLICATED);
        }
    }

}
