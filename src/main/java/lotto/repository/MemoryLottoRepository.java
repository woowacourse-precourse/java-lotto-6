package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLottoRepository implements LottoRepository {

    private Map<Lotto, Match> lottoStore = new HashMap<>();

    @Override
    public void save(List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto(lottoNumbers);
        lottoStore.put(lotto, null);
    }

    @Override
    public List<Lotto> findAll() {
        return lottoStore.keySet().stream().toList();
    }

    @Override
    public int findMatchCount(Match match) {
        int count = 0;

        for (Match lottoMatch : lottoStore.values()) {
            if (lottoMatch == match) {
                count++;
            }
        }

        return count;
    }


    @Override
    public void update(Lotto lotto, Match match) {
        lottoStore.put(lotto, match);
    }


    @Override
    public void clear() {
        lottoStore.clear();
    }
}
