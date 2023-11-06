package lotto.domain;

import java.util.LinkedHashMap;
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

    public static Map<LottoRank, Integer> calculateLottoResult(LottoSet lottoSet, Lotto lottoWinning, LottoBonus lottoBonus){
        Map<LottoRank, Integer> result = setResult();
        LottoRank rank;

        for(int i = 0; i < lottoSet.getLottoSet().size(); i++){
            int hit = lottoSet.getLottoSet().get(i).countHit(lottoWinning);
            boolean matchBonus = lottoSet.getLottoSet().get(i).containNumber(lottoBonus.getNumber());

            rank = LottoRank.valueOf(hit, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private static Map<LottoRank, Integer> setResult(){
        Map<LottoRank, Integer> result = new LinkedHashMap<>();

        for(LottoRank rank : LottoRank.values()){
            result.put(rank, 0);
        }
        return result;
    }
}
