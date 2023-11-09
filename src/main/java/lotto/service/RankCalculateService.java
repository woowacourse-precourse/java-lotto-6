package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class RankCalculateService {

    LottoRepository lottoRepository = LottoRepository.getInstance();

    public Rank calculateRankWith(Lotto lotto, WinningLotto winningLotto) {

        int count = (int) lotto.stream()
                               .filter(winningLotto::contains)
                               .count();

        boolean isBonusNumber = winningLotto.hasBonusNumberIn(lotto);

        return Arrays.stream(Rank.values())
                     .filter(rank -> rank.matchRank(count, isBonusNumber))
                     .findFirst()
                     .orElse(Rank.NONE);
    }

    public List<Rank> calculateRanks() {
        List<Lotto> lottos = lottoRepository.showAllLottos();
        WinningLotto winningLotto = lottoRepository.showWinningLotto();

        List<Rank> ranks = lottos.stream()
                                 .map(lotto -> calculateRankWith(lotto, winningLotto))
                                 .toList();
        return ranks;
    }

}
