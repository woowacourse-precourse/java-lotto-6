package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Match;

import java.util.List;

public interface LottoRepository {

    void save(List<Integer> lottoNumbers);

    List<Lotto> findAll();

    int findMatchCount(Match match);

    void update(Lotto lotto, Match match);

    void clear();
}
