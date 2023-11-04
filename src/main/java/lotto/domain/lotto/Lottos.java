package lotto.domain.lotto;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<LottoRank, Long> setLottoRankCountMap(final Lotto winningLotto, final int bonus) {
        EnumMap<LottoRank, Long> lottoRankCountMap = initializeLottoRankCountMap();
        setLottoRankCountMap(winningLotto, bonus, lottoRankCountMap);

        return lottoRankCountMap;
    }

    private EnumMap<LottoRank, Long> initializeLottoRankCountMap() {
        EnumMap<LottoRank, Long> lottoRankCountMap = new EnumMap<>(LottoRank.class);

        Arrays.stream(LottoRank.values())
                .forEach(rank -> lottoRankCountMap.put(rank, 0L));

        return lottoRankCountMap;
    }

    private void setLottoRankCountMap(Lotto winningLotto, int bonus, Map<LottoRank, Long> lottoRankCountMap) {
        lottos.stream()
                .map(lotto -> lotto.determineLottoRank(winningLotto, bonus))
                .forEach(rank -> lottoRankCountMap.put(rank, lottoRankCountMap.get(rank) + 1));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
