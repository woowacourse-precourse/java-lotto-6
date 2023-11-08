package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.vo.response.LottoResponse;

public class IssuedLottos {
    private final List<Lotto> lottos;

    public IssuedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int numberOfIssuedLottos() {
        return lottos.size();
    }

    public List<LottoResponse> convertToResponse() {
        return lottos.stream()
            .map(Lotto::convertToResponse)
            .collect(Collectors.toList());
    }

    public WinningRanks determineRanks(Lotto winnnigLotto, BonusNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for(Lotto lotto: lottos) {
            int criterion = lotto.countMatching(winnnigLotto);
            boolean hasBonusNum = bonusNumber.contained(lotto);
            Rank rank = Rank.determineByMatchingCount(criterion, hasBonusNum);
            ranks.add(rank);
        }
        return new WinningRanks(ranks);
    }
}
