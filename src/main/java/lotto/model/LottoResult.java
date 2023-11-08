package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.EnumMap;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;
    public LottoResult() {
        lottoResult = new EnumMap<LottoRank, Integer>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> lottoResult.put(lottoRank, 0));
    }

    public void addRank(LottoRank rank){
        lottoResult.put(rank, lottoResult.get(rank)+1);
    }
    public void addLottos(LottoMaker lottos, LottoCompare compare){
        lottos.getLottos().stream()
                .map((lotto) -> { return LottoRank.getRank(compare.winningCompare(lotto),compare.bonusCompare(lotto));})
                .forEach(this::addRank);

    }
    public Integer getRankCount(LottoRank rank){
        return lottoResult.get(rank);
    }




}