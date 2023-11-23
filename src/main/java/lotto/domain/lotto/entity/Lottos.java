package lotto.domain.lotto.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSize() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResultCount getResults(LottoAnswer lottoAnswer) {
        EnumMap<LottoResult, Integer> lottoResults = initResults();
        this.lottos.stream()
                .map(lotto -> LottoResult.getResult(lottoAnswer, lotto))
                .filter(result -> result != LottoResult.LOSE)
                .forEach(result -> putInLottoResults(lottoResults, result));
        return new LottoResultCount(lottoResults);
    }

    private static EnumMap<LottoResult, Integer> initResults() {
        EnumMap<LottoResult, Integer> results = new EnumMap<>(LottoResult.class);
        Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.LOSE)
                .forEach(result -> results.put(result, 0));
        return results;
    }

    private static void putInLottoResults(EnumMap<LottoResult, Integer> lottoResults, LottoResult result) {
        lottoResults.put(result, lottoResults.get(result) + 1);
    }
}
