package lotto.domain.lotto;

import lotto.dto.LottoResult;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<LottoRank, Long> getLottoRankCountMap(LottoResult lottoResult) {
        EnumMap<LottoRank, Long> lottoRankCountMap = initializeLottoRankCountMap();
        setLottoRankCountMap(lottoResult, lottoRankCountMap);

        return lottoRankCountMap;
    }

    private EnumMap<LottoRank, Long> initializeLottoRankCountMap() {
        EnumMap<LottoRank, Long> lottoRankCountMap = new EnumMap<>(LottoRank.class);

        Arrays.stream(LottoRank.values())
                .forEach(rank -> lottoRankCountMap.put(rank, 0L));

        return lottoRankCountMap;
    }

    private void setLottoRankCountMap(LottoResult lottoResult, Map<LottoRank, Long> lottoRankCountMap) {
        final Lotto winningLotto = lottoResult.getWinningLotto();
        final int bonusNumber = lottoResult.getBonusNumber();

        lottos.stream()
                .map(lotto -> lotto.determineLottoRank(winningLotto, bonusNumber))
                .forEach(rank -> lottoRankCountMap.put(rank, lottoRankCountMap.get(rank) + 1));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
