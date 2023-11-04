package lotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<LottoRank, Long> countLottoRanks(final Lotto winningLotto, final int bonus) {
        EnumMap<LottoRank, Long> lottoRankCountMap = new EnumMap<>(LottoRank.class);

        //init
        for (LottoRank rank : LottoRank.values()) {
            lottoRankCountMap.put(rank, 0L);
        }

        //lottoRanks
        List<LottoRank> lottoRanks = lottos.stream()
                .map(lotto -> lotto.determineLottoRank(winningLotto, bonus))
                .toList();

        for (LottoRank rank : lottoRanks) {
            lottoRankCountMap.put(rank, lottoRankCountMap.get(rank) + 1);
        }
        
        return lottoRankCountMap;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
