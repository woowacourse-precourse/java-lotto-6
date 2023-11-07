package lotto.controller;

import lotto.domain.Lotto;
import lotto.utils.LottoRank;
import lotto.domain.Lottos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    Map<LottoRank, Integer> totalPrize;

    public LottoService() {
        this.totalPrize = generateTotalPrize();
    }

    public void calculrateResult(Lottos lottos, Lotto winningLotto, int bonus) {
        for(Lotto userLotto : lottos.getLottos()){
            long matchingNumbers = userLotto.getMatchedNumber(winningLotto);
            switch ((int) matchingNumbers) {
                case 6:
                    totalPrize.put(LottoRank.FIRST_PRIZE, totalPrize.get(LottoRank.FIRST_PRIZE)+1);
                    break;
                case 5:
                    int unmatched = userLotto.getBonusNumber(winningLotto);
                    if(unmatched==bonus){
                        totalPrize.put(LottoRank.SECOND_PRIZE, totalPrize.get(LottoRank.SECOND_PRIZE)+1);
                        break;
                    }
                    totalPrize.put(LottoRank.THIRD_PRIZE, totalPrize.get(LottoRank.THIRD_PRIZE)+1);
                    break;
                case 4:
                    totalPrize.put(LottoRank.FOURTH_PRIZE, totalPrize.get(LottoRank.FOURTH_PRIZE)+1);
                    break;
                case 3:
                    totalPrize.put(LottoRank.FIFTH_PRIZE, totalPrize.get(LottoRank.FIFTH_PRIZE)+1);
                    break;
            }
        }
    }

    private Map<LottoRank, Integer> generateTotalPrize(){
        Map<LottoRank, Integer> totalPrize = new LinkedHashMap<>();
        for(LottoRank result: LottoRank.values()){
            totalPrize.put(result, 0);
        }
        return totalPrize;
    }

    public String getFinalPrize(long money){
        StringBuilder sb = new StringBuilder();
        int prize = 0;
        for(LottoRank lottoResult:totalPrize.keySet()){
            int count = totalPrize.get(lottoResult);
            sb.append(lottoResult.getResult())
                    .append(String.format("%d", count))
                    .append("개")
                    .append("\n");
            if(count>0) prize+= lottoResult.getPrize();
        }
        double rate = prize/(double)money*100;
        sb.append("총 수익률은 "+String.format("%.1f",rate)+"%입니다.");
        return sb.toString();
    }
}
