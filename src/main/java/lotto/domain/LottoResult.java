package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult(Map<LottoRank, Integer> lottoResult){
        this.lottoResult = lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResult(){
        return this.lottoResult;
    }

    public static LottoResult calculateLottoResult(LottoSet lottoSet, Lotto lottoWinning, LottoBonus lottoBonus){
        LottoRank rank;

        for(int i = 0; i < lottoSet.getLottoSet().size(); i++){
            rank = lottoWinning.match(lottoSet.get(i))
        }
    }
}
