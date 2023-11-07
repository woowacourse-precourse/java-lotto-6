package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoRank;
import lotto.domain.Lottos;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoService {
    Map<LottoRank, Integer> totalPrize;

    public LottoService() {
        this.totalPrize = generateTotalPrize();
    }

    private Map<LottoRank, Integer> generateTotalPrize(){
        Map<LottoRank, Integer> totalPrize = new LinkedHashMap<>();
        for(LottoRank result: LottoRank.values()){
            totalPrize.put(result, 0);
        }
        return totalPrize;
    }

    public void calculrateResult(Lottos lottos, Lotto winningLotto, int bonus) {
        for(Lotto userLotto : lottos.getLottos()){
            int matchedNumber = userLotto.getMatchedNumber(winningLotto);
            if(matchedNumber < LottoRank.FIFTH.getMatchedNumber()) continue;
            if(matchedNumber == LottoRank.FIRST.getMatchedNumber()){
                totalPrize.put(LottoRank.FIRST, totalPrize.get(LottoRank.FIRST)+1);
                continue;
            }
            if(matchedNumber == LottoRank.FOURTH.getMatchedNumber()){
                totalPrize.put(LottoRank.FOURTH, totalPrize.get(LottoRank.FOURTH)+1);
                continue;
            }
            if(matchedNumber == LottoRank.FIFTH.getMatchedNumber()){
                totalPrize.put(LottoRank.FIFTH, totalPrize.get(LottoRank.FIFTH)+1);
                continue;
            }
            int unmatchedNumber = userLotto.getUnmatchedNumber(winningLotto);
            if(unmatchedNumber == bonus) {
                totalPrize.put(LottoRank.SECOND, totalPrize.get(LottoRank.SECOND)+1);
                continue;
            }
            totalPrize.put(LottoRank.THIRD, totalPrize.get(LottoRank.THIRD)+1);
        }
    }

    public String getFinalPrize(long money){
        StringBuilder sb = new StringBuilder();
        int prize = 0;
        for(LottoRank lottoResult:totalPrize.keySet()){
            int count = totalPrize.get(lottoResult);
            sb.append(lottoResult.getResult())
                    .append(String.format("%d", count)+"개\n");
            if(count>0) prize+= lottoResult.getPrize();
        }
        double rate = prize/(double)money*100;
        sb.append("총 수익률은 "+String.format("%.1f",rate)+"%입니다.");
        return sb.toString();
    }
}
